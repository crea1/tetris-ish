package com.cozycoding.crea1.tetris.blocks;

import java.util.List;

/**
 * @author Marius Kristensen
 */
public interface TetrisBlock {
    List<Cell> getShape();

    void moveDown();

    void moveLeft();

    void moveRight();

    void rotateShapeCW();

}
