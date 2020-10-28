import java.lang.Integer;

public class lab03 {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Error: Usage: java lab03 boardSizeX boardSizeY steps preset");
            return;
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        Game.Preset p = Game.Preset.values()[Integer.parseInt(args[3])];
        Game game = new Game(x, y);
        game.initializePreset(p);

        for (int i = 0; i < steps; i++) {
            game.drawBoard();
            game.advanceGeneration();
        }
    }
}
