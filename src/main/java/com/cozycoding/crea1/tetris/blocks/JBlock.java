package com.cozycoding.crea1.tetris.blocks;                        //To change body of implemented methods use File | Settings | File Templates.

import com.cozycoding.crea1.tetris.GameRules;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marius Kristensen
 */
public class JBlock extends BlockRules implements TetrisBlock {
    private static final Color color = new Color(0xB9F373);
    /**
     * 012
     *   3
     */

    private Cell cell0 = new Cell(true, 4, 0, color);
    private Cell cell1 = new Cell(true, 5, 0, color);
    private Cell cell2 = new Cell(true, 6, 0, color);
    private Cell cell3 = new Cell(true, 6, 1, color);
    private List<Cell> cells = new ArrayList<>();

    private BlockDirection direction = BlockDirection.DOWN;

    public JBlock() {
        cells = Arrays.asList(cell0, cell1, cell2, cell3);
    }

    @Override
    public List<Cell> getShape() {
        return cells;
    }

    @Override
    public void moveDown() {
        for (Cell cell : cells) {
            cell.setY(cell.getY() + 1);
        }
    }

    @Override
    public void moveLeft() {
        for (Cell cell : cells) {
            cell.setX(cell.getX() - 1);
        }

    }

    @Override
    public void moveRight() {
        for (Cell cell : cells) {
            cell.setX(cell.getX() + 1);
        }

    }

    @Override
    public void rotateShapeCW(Cell[][] gameBoard) {
        BlockDirection directionAfterRotate = direction;
        List<Cell> cellsAfterRotation = new ArrayList<>();

        if (direction == BlockDirection.DOWN) {
            cellsAfterRotation = rotateLeft();
            directionAfterRotate = BlockDirection.LEFT;

        } else if (direction == BlockDirection.LEFT && cells.get(1).getX() != GameRules.noOfColumns - 1) {
            cellsAfterRotation = rotateUp();
            directionAfterRotate = BlockDirection.UP;

        } else if (direction == BlockDirection.UP && cells.get(1).getY() != GameRules.noOfRows - 1) {
            cellsAfterRotation = rotateRight();
            directionAfterRotate = BlockDirection.RIGHT;

        } else if (direction == BlockDirection.RIGHT && cells.get(1).getX() != 0) {
            cellsAfterRotation = rotateDown();
            directionAfterRotate = BlockDirection.DOWN;

        }

        if (directionAfterRotate != direction && rotationIsAllowed(gameBoard, cellsAfterRotation)) {
            cells = cellsAfterRotation;
            direction = directionAfterRotate;
        }
    }

    private List<Cell> rotateLeft() {
        cell0 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() - 1, color);
        cell1 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        cell2 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() + 1, color);
        cell3 = new Cell(true, cells.get(3).getX() - 2, cells.get(3).getY(), color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateUp() {
        cell0 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() + 1, color);
        cell1 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        cell2 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() - 1, color);
        cell3 = new Cell(true, cells.get(3).getX(), cells.get(3).getY() - 2, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateRight() {
        cell0 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() + 1, color);
        cell1 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        cell2 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() - 1, color);
        cell3 = new Cell(true, cells.get(3).getX() + 2, cells.get(3).getY(), color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateDown() {
        cell0 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() - 1, color);
        cell1 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        cell2 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() + 1, color);
        cell3 = new Cell(true, cells.get(3).getX(), cells.get(3).getY() + 2, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("|LBLOCK|");
        s.append(" Direction: " + direction);
        s.append(" Cells: [");
        for (Cell cell : cells) {
            s.append("(" + cell.getX() + ", " + cell.getY() + ")");
        }
        s.append("]");
        return s.toString();
    }
}
