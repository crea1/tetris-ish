package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.Cell;
import com.cozycoding.crea1.newtry.Blocks.SquareBlock;
import com.cozycoding.crea1.newtry.Blocks.TetrisBlock;

import java.util.List;

/**
 * @author Marius Kristensen
 */
public class GameRules {
    // |0|1|2|3|4|5|6|7|8|9
    protected static final int noOfColumns = 10;
    protected static final int noOfRows = 18;

    private Cell[][] gameBoard = new Cell[noOfRows][];
    private TetrisBlock activeBlock;

    public GameRules() {
        fillGameBoardWithEmptyRows(gameBoard);
    }

    public void fillGameBoardWithEmptyRows(Cell[][] gameBoard) {
        Cell[][] board = new Cell[gameBoard.length][];
        for (int row = 0; row < gameBoard.length; row++) {
            board[row] = fillCellRowWithEmptyCells(new Cell[noOfColumns], row);
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

    public Cell[] fillCellRowWithEmptyCells(Cell[] cells, int row) {
        for (int i = 0; i < cells.length; i++) {
            Cell cell = new Cell(false, i, row);
            cells[i] = cell;
        }
        return cells;
    }

    public void placeBlockOnGameBoard(TetrisBlock tetrisBlock) {
        this.activeBlock = tetrisBlock;
        }

    public void moveActiveBlockDown() {
        if (!isActiveBlockAtBottom()) {
            activeBlock.moveDown();
        }
    }

    public boolean isActiveBlockAtBottom() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.isFilled() && cell.getY() == noOfRows) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveBlockAtWalls() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.isFilled() && (cell.getX() == noOfColumns || cell.getX() == 0)) {
                return true;
            }
        }
        return false;
    }

    public Cell[][] getGameBoard() {
        return gameBoard;
    }

    public TetrisBlock getActiveBlock() {
        return activeBlock;
    }
}
