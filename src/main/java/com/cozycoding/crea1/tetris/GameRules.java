package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.Cell;
import com.cozycoding.crea1.tetris.blocks.TetrisBlock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marius Kristensen
 */
public class GameRules {
    // |0|1|2|3|4|5|6|7|8|9
    public static final int noOfColumns = 10;
    public static final int noOfRows = 18;


    final GameBoard gameBoardz;
    private Cell[][] gameBoard;
    private TetrisBlock activeBlock;
    private final RandomBagGenerator randomBagGenerator;
    private int currentBagBlockNumberPosition = 0;
    private List<TetrisBlock> bigBagOfBlocks;

    public GameRules() {
        gameBoardz = new GameBoard();
        this.gameBoard = gameBoardz.getGameBoard();
        randomBagGenerator = new RandomBagGenerator();
        bigBagOfBlocks = randomBagGenerator.createNewBag();
        placeBlockOnGameBoard();
    }


    public int removeFilledLines() {
        Set<Integer> rowsFilled = new HashSet<>();
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoardz.isRowFilled(gameBoard[row])) {
                rowsFilled.add(row);
                System.out.println("Row that's filled = " + row);
                for (int row2 = gameBoard.length - 1; row2 > 0; row2--) {
                    if (row2 <= row) {
                        Cell[] cellsAbove = gameBoard[row2 - 1];
                        for (Cell cell : cellsAbove) {
                            cell.setY(cell.getY() + 1);
                        }
                        System.out.println("Row" + (row2 - 1) + "is moved to row " + row2);
                        gameBoard[row2] = cellsAbove;
                    }
                }
                Cell[] cells = gameBoardz.fillCellRowWithEmptyCells(new Cell[noOfColumns], 0);
                gameBoard[0] = cells;
            }
        }
        return rowsFilled.size();
    }

    public boolean placeBlockOnGameBoard() {
        return placeBlockOnGameBoard(createRandomBlock());
    }

    public boolean placeBlockOnGameBoard(TetrisBlock tetrisBlock) {
        this.activeBlock = tetrisBlock;
        if (hasCrashedWithOtherCells()) {
            return false;
        }
        return true;
    }

    public TetrisBlock createRandomBlock() {
        TetrisBlock tetrisBlock = bigBagOfBlocks.get(currentBagBlockNumberPosition);
        currentBagBlockNumberPosition++;
        if (currentBagBlockNumberPosition > 6) {
            bigBagOfBlocks = randomBagGenerator.createNewBag();
            currentBagBlockNumberPosition = 0;
        }
        // System.out.println("Next Block: " + bigBagOfBlocks.get(currentBagBlockNumberPosition));
        return tetrisBlock;
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
