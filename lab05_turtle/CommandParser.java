/**
 * Class used for parsing text input to turtle commands.
 */
public class CommandParser {
    /**
     * Tries to parse the passed line of text to turtle command.
     * @param line line to be parsed
     * @return resulting command if successful, null otherwise
     */
    public Command parseCommand(String line) {
        String[] arr = line.split(" ");
        CommandType type;
        int x = 0;

        switch (arr[0]) {
            case "DRAW":
                type = CommandType.DRAW;
                break;
            case "MOVE":
                type = CommandType.MOVE;
                break;
            case "RIGHT":
                type = CommandType.RIGHT;
                break;
            case "LEFT":
                type = CommandType.LEFT;
                break;
            case "REPEAT":
                type = CommandType.REPEAT;
                break;
            case "NEXT":
                type = CommandType.NEXT;
                break;
            case "HOME":
                type = CommandType.HOME;
                break;
            case "END":
                type = CommandType.END;
                break;
            default:
                return null;
        }

        if (type.requiresNumber()) {
            if (arr.length < 2) {
                return null;
            }
            try {
                x = Integer.parseInt(arr[1]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return new Command(type, x);
    }
}
