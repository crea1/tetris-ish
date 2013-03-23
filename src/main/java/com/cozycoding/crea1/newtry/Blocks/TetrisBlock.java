package com.cozycoding.crea1.newtry.Blocks;

import java.util.List;

/**
 * @author Marius Kristensen
 */
public interface TetrisBlock {
    List<Cell> getShape();

    void moveDown();

    void moveLeft();

    void moveRight();

}
