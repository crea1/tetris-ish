package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.Cell;
import com.cozycoding.crea1.newtry.Blocks.TetrisBlock;

/**
 * @author Marius Kristensen
 */
public class GameRules {
    private static final int noOfColumns = 8;
    protected static final int noOfRows = 8;

    private Cell[][] gameBoard = new Cell[noOfRows][];

    public GameRules() {
        fillGameBoardWithEmptyRows(gameBoard);
    }

    public void fillGameBoardWithEmptyRows(Cell[][] gameBoard) {
        Cell[][] board = new Cell[gameBoard.length][];
        for (int row = 0; row < gameBoard.length; row++) {
            board[row] = fillCellRowWithEmptyCells(new Cell[noOfColumns]);
        }
        this.gameBoard = board;
    }

    public boolean isRowFilled(Cell[] cells) {
        for (Cell cell : cells) {
            if (!cell.isFilled()) {
                return false;
            }
        }
        return true;
    }

    public Cell[] fillCellRowWithEmptyCells(Cell[] cells) {
        for (int i = 0; i < cells.length; i++) {
            Cell cell = new Cell(false);
            cells[i] = cell;
        }
        return cells;
    }

    public void placeBlockOnGameBoard(Cell[][] gameBoard, TetrisBlock tetrisBlock) {
        Cell[][] gameBoardWithPlacedShape = gameBoard;
        Cell[][] shape = tetrisBlock.getShape();
        for (int row = 0; row < shape.length; row++) {
            Cell[] rowCells = shape[row];

            for (int column = 0; column < rowCells.length; column++) {
                gameBoardWithPlacedShape[row][column] = rowCells[column];
            }
        }
        this.gameBoard =  gameBoardWithPlacedShape;
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }
}
