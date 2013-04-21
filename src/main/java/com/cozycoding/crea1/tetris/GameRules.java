package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.Cell;
import com.cozycoding.crea1.tetris.blocks.IBlock;
import com.cozycoding.crea1.tetris.blocks.JBlock;
import com.cozycoding.crea1.tetris.blocks.LBlock;
import com.cozycoding.crea1.tetris.blocks.OBlock;
import com.cozycoding.crea1.tetris.blocks.SBlock;
import com.cozycoding.crea1.tetris.blocks.TBlock;
import com.cozycoding.crea1.tetris.blocks.TetrisBlock;
import com.cozycoding.crea1.tetris.blocks.ZBlock;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Marius Kristensen
 */
public class GameRules {
    // |0|1|2|3|4|5|6|7|8|9
    public static final int noOfColumns = 10;
    public static final int noOfRows = 18;

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

    public int removeFilledLines() {
        Set<Integer> rowsFilled = new HashSet<>();
        for (int row = 0; row < gameBoard.length; row++) {
            if (isRowFilled(gameBoard[row])) {
                rowsFilled.add(row);
                System.out.println("Row that's filled = " + row);
                //gameBoard[row] = fillCellRowWithEmptyCells(new Cell[noOfColumns], row);
                for (int row2 = gameBoard.length - 1; row2 > 0; row2--) {
                    if (row2 <= row) {
                        Cell[] cells = gameBoard[row2];
                        Cell[] cellsAbove = gameBoard[row2 - 1];
                        for (Cell cell : cellsAbove) {
                            cell.setY(cell.getY() + 1);
                        }
                        System.out.println("Row" + (row2 - 1) + "is moved to row " + row2);
                        gameBoard[row2] = cellsAbove;
                    }
                }
                Cell[] cells = fillCellRowWithEmptyCells(new Cell[noOfColumns], 0);
                gameBoard[0] = cells;
            }
        }
        return rowsFilled.size();
    }

    public Cell[] fillCellRowWithEmptyCells(Cell[] cells, int row) {
        for (int i = 0; i < cells.length; i++) {
            Cell cell = new Cell(false, i, row);
            cells[i] = cell;
        }
        return cells;
    }

    public void placeBlockOnGameBoard() {
        placeBlockOnGameBoard(createRandomBlock());
    }

    public void placeBlockOnGameBoard(TetrisBlock tetrisBlock) {
        this.activeBlock = tetrisBlock;
    }

    // TODO rewrite this to use random bags with random 7 pieces.
    public TetrisBlock createRandomBlock() {
        Random random = new Random();
        int x = random.nextInt(100);
        if (x < 15) {
            return new OBlock();
        } else if (x >= 15 && x < 30) {
            return new TBlock();
        } else if (x >= 30 && x < 45) {
            return new JBlock();
        } else if (x >=45 && x < 60) {
            return new LBlock();
        } else if (x >= 60 && x < 75) {
            return new SBlock();
        } else if (x >= 75 && x < 90) {
            return new ZBlock();
        } else {
            return new IBlock();
        }
    }

    public synchronized void moveActiveBlockDown() {
        if (!hasCrashedWithOtherCells()) {
            activeBlock.moveDown();
        }
    }

    public void moveActiveBlockLeft() {
        //todo also check if there are blocks to the left
        if (!isActiveBlockAtLeftWall() && !cellToTheLeftIsFilled()) {
            activeBlock.moveLeft();
        }
    }

    private boolean cellToTheLeftIsFilled() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.getY() < 0) {
                // We don't care if the cell is above the game board
                return false;
            } else if (gameBoard[cell.getY()][cell.getX() - 1].isFilled()) {
                return true;
            }
        }
        return false;
    }

    public void moveActiveBlockRight() {
        if (!isActiveBlockAtRightWall() && !cellToTheRightIsFilled()) {
            activeBlock.moveRight();
        }
    }

    private boolean cellToTheRightIsFilled() {
        for (Cell cell : activeBlock.getShape()) {

            if (cell.getY() < 0) {
                // We don't care if the cell is above the game board
                return false;
            } else if (gameBoard[cell.getY()][cell.getX() + 1].isFilled()) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveBlockAtBottom() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.isFilled() && cell.getY() == noOfRows-1) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveBlockAtLeftWall() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.isFilled() && cell.getX() == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isActiveBlockAtRightWall() {
        for (Cell cell : activeBlock.getShape()) {
            if (cell.isFilled() && cell.getX() == noOfColumns-1) {
                return true;
            }
        }
        return false;
    }



    public synchronized Cell[][] getGameBoard() {
        return gameBoard;
    }

    public synchronized TetrisBlock getActiveBlock() {
        return activeBlock;
    }

    public void stopActiveBlockAndMergeItWithBoard() {
        for (Cell cell : activeBlock.getShape()) {
            gameBoard[cell.getY()][cell.getX()].setFilled(true);
            gameBoard[cell.getY()][cell.getX()].setColor(cell.getColor());

        }
        activeBlock = null;
    }

    public boolean hasCrashedWithOtherCells() {
        if (isActiveBlockAtBottom()) {
            return true;
        }
        for (Cell cell : activeBlock.getShape()) {
            if (gameBoard[cell.getY() + 1][cell.getX()].isFilled()) {
                return true;
            }
        }
        return false;
    }

    public void rotateActiveBlock() {
        // TODO Check for crash when rotatin
        activeBlock.rotateShapeCW(gameBoard);
    }
}
