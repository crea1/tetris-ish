package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.Cell;
import com.cozycoding.crea1.newtry.Blocks.SquareBlock;
import com.cozycoding.crea1.newtry.Blocks.TetrisBlock;
import com.cozycoding.crea1.newtry.Blocks.TriangleBlock;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Marius Kristensen
 */
public class GameRulesTest {

    private Cell filledCell = new Cell(true);
    private Cell emptyCell = new Cell(false);
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
        Cell[] emptyCells = gameRules.fillCellRowWithEmptyCells(new Cell[8]);
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
    public void testPlaceSquareOnGameBoard() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        Cell[][] gameBoard = gameRules.getGameBoard();
        assertTrue(gameBoard[0][0].isFilled());
        assertTrue(gameBoard[0][1].isFilled());
        assertTrue(gameBoard[1][0].isFilled());
        assertTrue(gameBoard[1][1].isFilled());
    }

    @Test
    public void testPlaceTriangleBlock() throws Exception {
        TriangleBlock triangleBlock = new TriangleBlock();
        gameRules.placeBlockOnGameBoard(triangleBlock);
        Cell[][] gameBoard = gameRules.getGameBoard();
        assertFalse(gameBoard[0][0].isFilled()); assertTrue(gameBoard[0][1].isFilled()); assertFalse(gameBoard[0][2].isFilled());
        assertTrue(gameBoard[1][0].isFilled()); assertTrue(gameBoard[1][1].isFilled()); assertTrue(gameBoard[1][2].isFilled());
    }

    @Test
    public void testWhenPlacedSquareCellsShouldHaveCorrectXandY() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        Cell[][] gameBoard = gameRules.getGameBoard();
        TetrisBlock activeBlock = gameRules.getActiveBlock();
        Cell[][] activeBlockShape = activeBlock.getShape();
        assertEquals(0, activeBlockShape[0][0].getX());
        assertEquals(0, activeBlockShape[0][0].getY());
    }

    @Test
    public void testMoveShapeDown() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        gameRules.placeBlockOnGameBoard(squareBlock);
        gameRules.moveActiveBlockDown();
        Cell[][] gameBoard = gameRules.getGameBoard();
        printGameBoard(gameBoard);

        assertFalse(gameBoard[0][0].isFilled());
        assertFalse(gameBoard[0][1].isFilled());
        assertTrue(gameBoard[1][0].isFilled());
        assertTrue(gameBoard[1][1].isFilled());
        assertTrue(gameBoard[2][0].isFilled());
        assertTrue(gameBoard[2][1].isFilled());

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
