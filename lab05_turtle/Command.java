public class Command {

    Command(CommandType type, int x) {
        this.type = type;
        this.x = x;
    }
    CommandType type;
    int x;
}

enum CommandType {
    DRAW, MOVE, RIGHT, LEFT, REPEAT, NEXT, HOME, END;
    boolean requiresNumber() {
        return !(this == NEXT || this == HOME || this == END);
    }
}
