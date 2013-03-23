package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.SquareBlock;

import java.awt.Dimension;

/**
 * @author Marius Kristensen
 */
public class Tetris2 {
    private static final int windowWidth = 320;
    private static final int windowHeight = 576;

    private static final String title = "Tetris by crea1 - Cozy Coding";
    private static GameRules gameRules;
    private static GamePanel gamePanel;

    public static void main(String[] args) {
        setUpWindow();
    }

    private static void setUpWindow() {
        gameRules = new GameRules();
        gameRules.placeBlockOnGameBoard(new SquareBlock());
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        gamePanel = new GamePanel(new Dimension(windowWidth, windowHeight));
        gamePanel.addKeyListener(new ArrowKeyListener());
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
        window.add(gamePanel);
    }

    public static GameRules getGameRules() {
        return gameRules;
    }

    public static void paintGameBoard() {
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
    }

}
