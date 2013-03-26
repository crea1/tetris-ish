package com.cozycoding.crea1.tetris.blocks;

import java.util.List;

/**
 * @author Marius Kristensen
 */
public class BlockRules {
    protected boolean rotationIsAllowed(Cell[][] gameBoard, List<Cell> cells1) {
        for (Cell cell : cells1) {
            if (cell.getY() > 0) {
                if (gameBoard[cell.getY()][cell.getX()].isFilled()) {
                    return false;
                }
            }
        }
        return true;
    }
}
