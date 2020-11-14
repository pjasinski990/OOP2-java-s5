/**
 * Class that implements FIFO queue for turtle commands.
 * Automatically repeats commands that are enclosed in REPEAT ... NEXT
 */
public class CommandQ {
    private class CommandNode {
        CommandNode(Command c) {
            command = c;
        }
        Command command;
        CommandNode next = null;
        CommandNode prev = null;
    }

    private CommandNode head = null;
    private CommandNode tail = null;
    private boolean repeating = false;
    private int repeatCount = 0;

    /**
     * Enqueues new command
     * @param comm command to be enqueued
     */
    public void enQ(Command comm) {
        CommandNode newNode = new CommandNode(comm);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
    }

    /**
     * Dequeues next command. Checks for existence of REPEAT blocks
     * and repeats enclosed commands as needed.
     *
     * @return Command next command in the queue, null if empty
     */
    public Command deQ() {
        if (head == null) {
            return null;
        }

        Command result = head.command;
        if (result.type == CommandType.REPEAT && result.x > 0) {
            repeating = true;
            repeatCount++;
            result.x--;
        }
        else if (result.type == CommandType.NEXT && repeating) {
            repeating = false;
            goBack(repeatCount);
            repeatCount = 0;
            return result;
        }
        else if (repeating) {
            repeatCount++;
        }
        head = head.next;
        return result;
    }

    private void goBack(int steps) {
        for(int i = 0; i < steps; i++) {
            head = head.prev;
        }
    }
}
