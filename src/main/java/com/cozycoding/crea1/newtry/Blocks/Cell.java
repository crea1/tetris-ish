package com.cozycoding.crea1.newtry.Blocks;

/**
 * @author Marius Kristensen
 */
public class Cell {
    private boolean isFilled;

    public Cell(boolean filled) {
        isFilled = filled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }


}
