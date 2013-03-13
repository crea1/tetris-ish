package com.cozycoding.crea1;

import com.cozycoding.crea1.shapes.RectangleBlock;

import java.awt.Dimension;

/**
 * Tetris
 * Well, kind of, and not yet. Still a long way to go...
 *
 * @author Marius Haugli Kristensen
 */
public class Tetris {
    private static final int windowWidth = 320;
    private static final int windowHeight = 240;
    private static final String title = "Tetris by crea1 - Cozy Coding";

    public static void main(String[] args) {
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        RectangleBlock rectangleBlock = new RectangleBlock(160, 0);
        final TetrisPanel tetrisPanel = new TetrisPanel(new Dimension(windowWidth, windowHeight), rectangleBlock);
        window.add(tetrisPanel);
    }
}
