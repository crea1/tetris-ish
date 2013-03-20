package com.cozycoding.crea1.newtry.Blocks;

/**
 * @author Marius Kristensen
 */
public class TriangleBlock implements TetrisBlock {

    Cell filledCell = new Cell(true);
    Cell emptyCell = new Cell(false);
    Cell[] row1 = {emptyCell, filledCell, emptyCell};
    Cell[] row2 = {filledCell, filledCell, filledCell};
    Cell[][] shape = {row1, row2};

    @Override
    public Cell[][] getShape() {
        return shape;
    }
}
