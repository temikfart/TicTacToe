package tictactoe.views;

public enum ActionCommand {
    START_GAME,
    EXIT,
    CHANGE_SIZE,
    RESET,
    SHOW_HISTORY,
    RETURN,
    MOVE,
    NONE;

    public static ActionCommand resolve(String cmd) {
        try {
            return valueOf(cmd);
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
