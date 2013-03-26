package com.cozycoding.crea1.tetris.blocks;

import com.cozycoding.crea1.tetris.GameRules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marius Kristensen
 */
public class PyramidBlock implements TetrisBlock {
    private static final Color color = new Color(0x3F3ABC);
    /**
     * 123
     * 4
     */
    private Cell cell0 = new Cell(true, 4, 0, color);
    private Cell cell1 = new Cell(true, 5, 0, color);
    private Cell cell2 = new Cell(true, 6, 0, color);
    private Cell cell3 = new Cell(true, 5, 1, color);
    private List<Cell> cells = new ArrayList<>();
    private BlockDirection direction = BlockDirection.DOWN;


    public PyramidBlock() {
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
        // The middle cell is the same for all transformations
        cell1 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        if (direction == BlockDirection.DOWN) {
            List<Cell> cells1 = rotateLeft();
            if (checkIfRotationIsAllowed(gameBoard, cells1)) {
                cells = cells1;
                direction = BlockDirection.LEFT;
            }
        } else if (direction == BlockDirection.LEFT && cell1.getX() != GameRules.noOfColumns - 1) {
            List<Cell> cells1 = rotateUp();
            if (checkIfRotationIsAllowed(gameBoard, cells1)) {
                cells = cells1;
                direction = BlockDirection.UP;
            }
        } else if (direction == BlockDirection.UP && cell1.getY() != GameRules.noOfRows - 1) {
            List<Cell> cells1 = rotateRight();
            if (checkIfRotationIsAllowed(gameBoard, cells1)) {
                cells = cells1;
                direction = BlockDirection.RIGHT;
            }
        } else if (direction == BlockDirection.RIGHT && cell1.getX() != 0) {
            List<Cell> cells1 = rotateDown();
            if (checkIfRotationIsAllowed(gameBoard, cells1)) {
                cells = cells1;
                direction = BlockDirection.DOWN;
            }
        }
    }

    private boolean checkIfRotationIsAllowed(Cell[][] gameBoard, List<Cell> cells1) {
        for (Cell cell : cells1) {
            if (cell.getY() > 0) {
                if (gameBoard[cell.getY()][cell.getX()].isFilled()) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Cell> rotateLeft() {
        cell0 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() - 1, color);
        cell2 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() + 1, color);
        cell3 = new Cell(true, cells.get(3).getX() - 1, cells.get(3).getY() - 1, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateUp() {
        cell0 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() + 1, color);
        cell2 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() - 1, color);
        cell3 = new Cell(true, cells.get(3).getX() + 1, cells.get(3).getY() - 1, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateRight() {
        cell0 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() + 1, color);
        cell2 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() - 1, color);
        cell3 = new Cell(true, cells.get(3).getX() + 1, cells.get(3).getY() + 1, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    private List<Cell> rotateDown() {
        cell0 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() - 1, color);
        cell2 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() + 1, color);
        cell3 = new Cell(true, cells.get(3).getX() - 1, cells.get(3).getY() + 1, color);
        return Arrays.asList(cell0, cell1, cell2, cell3);
    }

    }
}

