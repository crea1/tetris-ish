package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.Cell;

/**
 * @author Marius Kristensen
 */
public class GameBoard {

    private Cell[][] gameBoard = new Cell[GameRules.noOfRows][];

    public GameBoard() {
        fillGameBoardWithEmptyRows(this.gameBoard);
    }

    public void fillGameBoardWithEmptyRows(Cell[][] gameBoard) {
        Cell[][] board = new Cell[gameBoard.length][];
        for (int row = 0; row < gameBoard.length; row++) {
            board[row] = fillCellRowWithEmptyCells(new Cell[GameRules.noOfColumns], row);
        }
        this.gameBoard = board;
    }

    public Cell[] fillCellRowWithEmptyCells(Cell[] cells, int row) {
        for (int i = 0; i < cells.length; i++) {
            Cell cell = new Cell(false, i, row);
            cells[i] = cell;
        }
        return cells;
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }
}
