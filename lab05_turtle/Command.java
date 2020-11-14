/**
 * Class that contains data required to execute a command by a turtle.
 */
public class Command {
    public Command(CommandType type, int x) {
        this.type = type;
        this.x = x;
    }
    CommandType type;
    int x;
}

enum CommandType {
    DRAW, MOVE, RIGHT, LEFT, REPEAT, NEXT, HOME, END;
    /**
     * Checks if enum type command requires an argument to be executed.
     * @return resulting logical value
     */
    public boolean requiresNumber() {
        return !(this == NEXT || this == HOME || this == END);
    }
}
