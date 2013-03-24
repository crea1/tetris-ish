package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.SquareBlock;

import java.awt.Dimension;

/**
 * @author Marius Kristensen
 */
public class Game implements Runnable {
    private static final int windowWidth = 320;
    private static final int windowHeight = 576;

    private static final String title = "Tetris by crea1 - Cozy Coding";
    private static GameRules gameRules;
    private static GamePanel gamePanel;

    public Game() {
        gameRules = new GameRules();
        gameRules.placeBlockOnGameBoard(new SquareBlock());
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        gamePanel = new GamePanel(new Dimension(windowWidth, windowHeight));
        gamePanel.addKeyListener(new ArrowKeyListener());
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
        window.add(gamePanel);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameRules.moveActiveBlockDown();
            gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
        }
    }


    public static GameRules getGameRules() {
        return gameRules;
    }


    public static void paintGameBoard() {
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
    }
}
