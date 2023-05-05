package tictactoe.models;

public class GameBoardModel {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 5;
    public static int BOARD_SIZE = MIN_SIZE;

    private class Cell {
        private CellState state = CellState.EMPTY;

        public void changeState(CellState state) {
            this.state = state;
        }

        public CellState state() {
            return state;
        }
    }

    private Cell[][] gameBoard = createGameBoard(BOARD_SIZE);
    private GameResult gameResult = GameResult.RESUME;
    private CellState nextMove = CellState.X;
    private int moveCounter = 0;

    public boolean move(int row, int col) {
        Cell cell = gameBoard[row][col];
        if (cell.state() != CellState.EMPTY)
            return false;

        moveCounter++;
        cell.changeState(nextMove);
        gameResult = checkGameResult(row, col);

        if (nextMove == CellState.X)
            nextMove = CellState.O;
        else
            nextMove = CellState.X;

        return true;
    }

    public GameResult gameResult() {
        return gameResult;
    }

    public CellState nextMove() {
        return nextMove;
    }

    public void reset() {
        gameBoard = createGameBoard(BOARD_SIZE);
        gameResult = GameResult.RESUME;
        nextMove = CellState.X;
        moveCounter = 0;
    }

    private GameResult checkGameResult(int row, int col) {
        if (isWin(row, col))
            return GameResult.WIN;
        if (moveCounter == BOARD_SIZE * BOARD_SIZE)
            return GameResult.TIE;
        return GameResult.RESUME;
    }

    private boolean isWin(int row, int col) {
        int countRow = 0;
        int countCol = 0;
        int countLDiag = 0;
        int countRDiag = 0;
        int size = BOARD_SIZE;

        for (int i = 0; i < size; i++) {
            if (gameBoard[row][i].state() == nextMove)
                countRow++;
            if (gameBoard[i][col].state() == nextMove)
                countCol++;
            if (gameBoard[i][i].state() == nextMove)
                countLDiag++;
            if (gameBoard[i][size - i - 1].state() == nextMove)
                countRDiag++;
        }

        return countRow == size || countCol == size || countLDiag == size || countRDiag == size;
    }

    private Cell[][] createGameBoard(int size) {
        Cell[][] board = new Cell[size][size];
        for (Cell[] cellRow : board)
            for (int j = 0; j < size; j++)
                cellRow[j] = new Cell();

        return board;
    }
}
