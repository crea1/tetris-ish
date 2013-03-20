package com.cozycoding.crea1.newtry.Blocks;

/**
 * @author Marius Kristensen
 */
public class SquareBlock implements TetrisBlock {
    /* Setup square shape */

    Cell filledCell = new Cell(true);
    Cell[] row1 = {filledCell, filledCell};
    Cell[] row2 = {filledCell, filledCell};
    Cell[][] shape = {row1, row2};


    @Override
    public Cell[][] getShape() {
        return shape;
    }
}
