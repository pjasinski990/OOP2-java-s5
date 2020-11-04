import java.util.Random;

public class Game {
    public static enum Preset {
        RANDOM, BOAT, BLINKER, GLIDER
    }

    public Game(int x, int y) {
        board = new Board(x, y);
    }

    public void initializePreset(Preset p) {
        switch (p) {
            case RANDOM: board.drawRandom();
            break;
            case BLINKER: board.drawBlinker();
            break;
            case BOAT: board.drawBoat();
            break;
            case GLIDER: board.drawGlider();
            break;
            default: throw new IllegalArgumentException("Preset not defined");
        }
    }

    public void advanceGeneration() {
        Cell[][] nextGen = new Cell[board.getSizeX()][board.getSizeY()];
        for(int i = 0; i < board.getSizeX(); i++) { 
            for(int j = 0; j < board.getSizeY(); j++) {
                Cell currentCell = board.getCells()[i][j];
                if (currentCell.countNeighbours() == 3) {
                    nextGen[i][j] = new Cell(i, j, board, true);
                }
                else if (currentCell.countNeighbours() == 2 && currentCell.getState() == true) {
                    nextGen[i][j] = new Cell(i, j, board, true);
                }
                else {
                    nextGen[i][j] = new Cell(i, j, board, false);
                }
            }
        }
        board.setCells(nextGen);
        generationCount++;
    }

    public void drawBoard() {
        int space = (board.getSizeX() - 3) / 2;
        System.out.println("-".repeat(space) + " " + generationCount + " " + "-".repeat(board.getSizeX() - space - 3));
        board.display();
    }

    private Board board;
    private int generationCount = 0;
}

class Board {
    Board(int x, int y) {
        sizeX = x;
        sizeY = y;
        cells = new Cell[x][y];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j, this);
            }
        }
    }

    void clear() {
        for (Cell[] arr: cells) {
            for (Cell c: arr) {
                c.clear();
            }
        }
    }

    void display() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                cells[j][i].draw();
            }
            System.out.println();
        }
    }

    void drawBlinker() {
        if (sizeX >= 3 && sizeY >= 3) {
            clear();
            int xcenter = sizeX / 2;
            int ycenter = sizeY / 2;
            cells[xcenter][ycenter].set();
            cells[xcenter][ycenter-1].set();
            cells[xcenter][ycenter+1].set();
        }
    }

    void drawBoat() {
        if (sizeX >= 3 && sizeY >= 3) {
            clear();
            int xcenter = sizeX / 2;
            int ycenter = sizeY / 2;
            cells[xcenter-1][ycenter-1].set();
            cells[xcenter][ycenter-1].set();
            cells[xcenter-1][ycenter].set();
            cells[xcenter+1][ycenter].set();
            cells[xcenter][ycenter+1].set();
        }
    }

    void drawGlider() {
        if (sizeX >= 3 && sizeY >= 3) {
            clear();
            int xcenter = sizeX / 2;
            int ycenter = sizeY / 2;
            cells[xcenter-1][ycenter-1].set();
            cells[xcenter][ycenter-1].set();
            cells[xcenter+1][ycenter-1].set();
            cells[xcenter-1][ycenter].set();
            cells[xcenter][ycenter+1].set();
        }
    }

    void drawRandom() {
        Random r = new Random();
        for (Cell[] arr: cells) {
            for(Cell c: arr) {
                if (r.nextInt() % 8 == 0) {c.set();}
                else {c.clear();}
            }
        }
    }

    boolean isOnBoard(int x, int y) {
        return (x >= 0 && y >= 0 && x < sizeX && y < sizeY);
    }

    Cell[][] getCells() {return cells;}
    void setCells(Cell[][] arr) {cells = arr;}
    int getSizeX() {return sizeX;}
    int getSizeY() {return sizeY;}

    private Cell[][] cells;
    private int sizeX;
    private int sizeY;
}

class Cell {
    Cell(int x, int y, Board o) {
        posX = x;
        posY = y;
        owner = o;
    }

    Cell(int x, int y, Board o, boolean state) {
        this(x, y, o);
        this.state = state;
    }

    int countNeighbours() {
        Cell[][] cells = owner.getCells();
        int[] xs = {posX-1, posX, posX+1, posX-1, posX+1, posX-1, posX, posX+1};
        int[] ys = {posY-1, posY-1, posY-1, posY, posY, posY+1, posY+1, posY+1};

        int res = 0;
        for (int i = 0; i < xs.length; i++) {
            if (owner.isOnBoard(xs[i], ys[i]) && cells[xs[i]][ys[i]].getState()) {
                res++;
            }
        }
        return res;
    }

    void draw() {
        if (state) {
            System.out.print("X");
        }
        else {
            System.out.print(".");
        }
    }

    void clear() {state = false;}

    void set() {state = true;}

    boolean getState() {return state;}

    private Board owner;
    private boolean state = false;
    private int posX;
    private int posY;
}
