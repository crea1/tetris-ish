package com.cozycoding.crea1.tetris.blocks;

import com.cozycoding.crea1.tetris.blocks.Cell;
import com.cozycoding.crea1.tetris.blocks.SquareBlock;
import com.cozycoding.crea1.tetris.blocks.TetrisBlock;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Marius Kristensen
 */
public class SquareBlockTest {


    @Test
    public void testSavingOfXYOnSquareBlock() throws Exception {
        TetrisBlock squareBlock = new SquareBlock();
        for (Cell cell : squareBlock.getShape()) {
            cell.setX(99);
            cell.setY(-99);
        }
        for (Cell cell : squareBlock.getShape()) {
            assertEquals(99, cell.getX());
            assertEquals(-99, cell.getY());
        }
    }

    @Test
    public void testMoveSquareBlockDown() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        squareBlock.moveDown();
        List<Cell> shape = squareBlock.getShape();
        int numberOfCellsWithOneAsY = 0;
        int numberOfCellsWithTwoAsY = 0;
        for (Cell cell : shape) {
            if (cell.getY() == 1) {
                numberOfCellsWithOneAsY++;
            } else if (cell.getY() == 2) {
                numberOfCellsWithTwoAsY++;
            }
        }
        assertEquals(2, numberOfCellsWithOneAsY);
        assertEquals(2, numberOfCellsWithTwoAsY);
    }

    @Test
    public void testMoveSquareLeft() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        squareBlock.moveLeft();
        int numberOfCellsWithThreeAsX = 0;
        int numberOfCellsWithFourAsX = 0;
        List<Cell> shape = squareBlock.getShape();
        for (Cell cell : shape) {
            if (cell.getX() == 3) {
                numberOfCellsWithThreeAsX++;
            } else if (cell.getX() == 4) {
                numberOfCellsWithFourAsX++;
            }
        }
        assertEquals(2, numberOfCellsWithThreeAsX);
        assertEquals(2, numberOfCellsWithFourAsX);
    }

    @Test
    public void testMoveSquareRight() throws Exception {
        SquareBlock squareBlock = new SquareBlock();
        squareBlock.moveRight();
        int numberOfCellsWithSixAsX = 0;
        int numberOfCellsWithFiveAsX = 0;
        List<Cell> shape = squareBlock.getShape();
        for (Cell cell : shape) {
            if (cell.getX() == 5) {
                numberOfCellsWithFiveAsX++;
            } else if (cell.getX() == 6) {
                numberOfCellsWithSixAsX++;
            }
        }
        assertEquals(2, numberOfCellsWithFiveAsX);
        assertEquals(2, numberOfCellsWithSixAsX);
    }
}
