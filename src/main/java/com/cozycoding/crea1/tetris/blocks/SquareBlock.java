package com.cozycoding.crea1.tetris.blocks;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marius Kristensen
 */
public class SquareBlock implements TetrisBlock {
    private static final Color color = new Color(0xFF0056);

    /* Setup square shape */
    Cell cell1 = new Cell(true,4,0, color);
    Cell cell2 = new Cell(true,4,1, color);
    Cell cell3 = new Cell(true,5,0, color);
    Cell cell4 = new Cell(true,5,1, color);
    List<Cell> cells = new ArrayList<>();

    public SquareBlock() {
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
            cell.setX(cell.getX() -1);
        }
    }

    @Override
    public void moveRight() {
        for (Cell cell : cells) {
            cell.setX(cell.getX() +1);
        }
    }

}
