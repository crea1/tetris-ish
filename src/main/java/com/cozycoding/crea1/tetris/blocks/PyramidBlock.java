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
     *  4
     *
     */
    Cell cell1 = new Cell(true, 4, 0, color);
    Cell cell2 = new Cell(true, 5, 0, color);
    Cell cell3 = new Cell(true, 6, 0, color);
    Cell cell4 = new Cell(true, 5, 1, color);
    private List<Cell> cells = new ArrayList<>();
    private BlockDirection direction = BlockDirection.DOWN;


    public PyramidBlock() {
        cells = Arrays.asList(cell1, cell2, cell3, cell4);
    }

    @Override
    public List<Cell> getShape() {
        return cells;
    }

    @Override
    public void moveDown() {
        for (Cell cell : cells) {
            cell.setY(cell.getY() +1);
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
            cell.setX(cell.getX() +1);
        }

    }

    @Override
    public void rotateShape() {
        // The middle cell is the same for all transformations
        cell2 = new Cell(true, cells.get(1).getX(), cells.get(1).getY(), color);
        if (direction == BlockDirection.DOWN) {
            cell1 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() - 1, color);
            cell3 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() + 1, color);
            cell4 = new Cell(true, cells.get(3).getX() - 1, cells.get(3).getY() - 1, color);
            direction = BlockDirection.LEFT;
        } else if (direction == BlockDirection.LEFT && cell2.getX() != GameRules.noOfColumns - 1) {
            cell1 = new Cell(true, cells.get(0).getX() + 1, cells.get(0).getY() + 1, color);
            cell3 = new Cell(true, cells.get(2).getX() - 1, cells.get(2).getY() - 1, color);
            cell4 = new Cell(true, cells.get(3).getX() + 1, cells.get(3).getY() - 1, color);
            direction = BlockDirection.UP;
        } else if (direction == BlockDirection.UP) {
            cell1 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() + 1, color);
            cell3 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() - 1, color);
            cell4 = new Cell(true, cells.get(3).getX() + 1, cells.get(3).getY() + 1, color);
            direction = BlockDirection.RIGHT;
        } else if (direction == BlockDirection.RIGHT && cell2.getX() != 0) {
            cell1 = new Cell(true, cells.get(0).getX() - 1, cells.get(0).getY() - 1, color);
            cell3 = new Cell(true, cells.get(2).getX() + 1, cells.get(2).getY() + 1, color);
            cell4 = new Cell(true, cells.get(3).getX() - 1, cells.get(3).getY() + 1, color);
            direction = BlockDirection.DOWN;
        }

        cells = Arrays.asList(cell1, cell2, cell3, cell4);
    }
}

