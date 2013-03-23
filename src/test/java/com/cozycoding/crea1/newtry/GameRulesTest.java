package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.Cell;
import com.cozycoding.crea1.newtry.Blocks.SquareBlock;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * @author Marius Kristensen
 */
public class GameRulesTest {

    private Cell filledCell = new Cell(true,0,0);
    private Cell emptyCell = new Cell(false,0,0);
    GameRules gameRules;

    @Before
    public void setUp() throws Exception {
        gameRules = new GameRules();
    }

    @Test
    public void testGameBoardIsFilledWithEmptyCells() throws Exception {
        for (int row = 0; row < gameRules.getGameBoard().length; row++) {
            assertFalse(gameRules.isRowFilled(gameRules.getGameBoard()[row]));
        }
    }

    @Test
    public void testGameBoardFullOfEmptyRowsOnGameStart() {
        Cell[] emptyCells = gameRules.fillCellRowWithEmptyCells(new Cell[8], 0);
        assertFalse(gameRules.isRowFilled(emptyCells));
    }

    @Test
    public void testRowIsFilledReturnTrue() throws Exception {
        Cell[] cellRow = {filledCell, filledCell, filledCell, filledCell};
        assertTrue(gameRules.isRowFilled(cellRow));
    }

    @Test
    public void testOneRowIsNotFilledReturnsFalse() throws Exception {
        Cell[] cellRow = {filledCell, emptyCell, filledCell, filledCell};
        assertFalse(gameRules.isRowFilled(cellRow));
    }

    @Test
    public void testMoveBlockUntilBottomButNoFurther() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        while (!gameRules.isActiveBlockAtBottom()) {
            gameRules.getActiveBlock().moveDown();
            if (gameRules.getActiveBlock().getShape().get(3).getY() == gameRules.noOfRows) {
                fail();
            }
        }
        assertEquals(gameRules.noOfRows-1, gameRules.getActiveBlock().getShape().get(3).getY());
    }

    @Test
    public void testMoveBlockLeftToWallButNoFurther() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        while (!gameRules.isActiveBlockAtLeftWall()) {
            gameRules.getActiveBlock().moveLeft();
            if (gameRules.getActiveBlock().getShape().get(0).getX() < 0) {
                fail();
            }
        }
        assertEquals(0, 0);
    }

    @Test
    public void testMoveBlockRightToWallButNoFurther() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        while (!gameRules.isActiveBlockAtRightWall()) {
            gameRules.getActiveBlock().moveRight();
            if (gameRules.getActiveBlock().getShape().get(1).getX() == gameRules.noOfColumns) {
                fail();
            }
        }
        assertEquals(gameRules.noOfColumns - 1, gameRules.getActiveBlock().getShape().get(2).getX());
    }

    @Test
    public void testMergeActiveBlockWithGameboard() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        gameRules.stopActiveBlockAndMergeItWithBoard();
        assertTrue(gameRules.getGameBoard()[0][4].isFilled());
        assertTrue(gameRules.getGameBoard()[0][4].isFilled());
        assertTrue(gameRules.getGameBoard()[1][5].isFilled());
        assertTrue(gameRules.getGameBoard()[1][5].isFilled());
    }

    @Test
    public void testCrashWithOtherBlock() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        while (!gameRules.isActiveBlockAtBottom()) {
            gameRules.getActiveBlock().moveDown();
        }
        gameRules.stopActiveBlockAndMergeItWithBoard();
        SquareBlock secondBlock = new SquareBlock();
        secondBlock.moveLeft();
        gameRules.placeBlockOnGameBoard(secondBlock);
        while (!gameRules.hasCrashedWithOtherCells()) {
            gameRules.getActiveBlock().moveDown();
        }
        gameRules.stopActiveBlockAndMergeItWithBoard();

        assertTrue(gameRules.getGameBoard()[14][3].isFilled());
        assertTrue(gameRules.getGameBoard()[15][3].isFilled());
        assertTrue(gameRules.getGameBoard()[14][4].isFilled());
        assertTrue(gameRules.getGameBoard()[15][4].isFilled());
    }

    private void printGameBoard(Cell[][] gameBoard) {
        System.out.print(" |");
        for (int i = 0; i < gameBoard[0].length; i++) {
            System.out.print(i);
        }
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print("\n"+ i +"|");
            Cell[] row = gameBoard[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j].isFilled()) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
        }
    }


}
