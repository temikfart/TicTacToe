package tictactoe.models;

import tictactoe.TicTacToe;

public class GameBoardModel {
    private class Cell {
        private CellState state = CellState.EMPTY;

        public void changeState(CellState state) {
            this.state = state;
        }

        public CellState state() {
            return state;
        }
    }

    private final Cell[][] gameBoard = createGameBoard();
    private GameResult gameResult = GameResult.RESUME;
    private CellState nextMove = CellState.X;
    private int moveCounter = 0;

    public boolean move(int row, int col) {
        Cell cell = gameBoard[row][col];
        if (cell.state() != CellState.EMPTY)
            return false;

        moveCounter++;
        gameResult = checkGameResult(row, col);

        cell.changeState(nextMove);
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

    public void clear() {
        gameResult = GameResult.RESUME;
        nextMove = CellState.X;
        moveCounter = 0;
        for (Cell[] cellRow : gameBoard)
            for (Cell cell : cellRow)
                cell.changeState(CellState.EMPTY);
    }

    private GameResult checkGameResult(int row, int col) {
        if (isWin(row, col))
            return GameResult.WIN;
        if (moveCounter == TicTacToe.BOARD_SIZE * TicTacToe.BOARD_SIZE)
            return GameResult.TIE;
        return GameResult.RESUME;
    }

    private boolean isWin(int row, int col) {
        int countRow = 0;
        int countCol = 0;
        int countLDiag = 0;
        int countRDiag = 0;
        int size = TicTacToe.BOARD_SIZE;

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

    private Cell[][] createGameBoard() {
        Cell[][] board = new Cell[TicTacToe.BOARD_SIZE][TicTacToe.BOARD_SIZE];
        for (Cell[] cellRow : board)
            for (int j = 0; j < TicTacToe.BOARD_SIZE; j++)
                cellRow[j] = new Cell();

        return board;
    }
}
