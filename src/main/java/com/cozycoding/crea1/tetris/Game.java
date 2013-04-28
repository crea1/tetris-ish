package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.ui.ArrowKeyListener;
import com.cozycoding.crea1.tetris.ui.GamePanel;
import com.cozycoding.crea1.tetris.ui.ScorePanel;
import com.cozycoding.crea1.tetris.ui.Window;

import java.awt.BorderLayout;
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
    private static ScorePanel scorePanel;

    public Game() {
        gameRules = new GameRules();
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        gamePanel = new GamePanel(new Dimension(windowWidth, windowHeight));
        gamePanel.addKeyListener(new ArrowKeyListener());
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());

        scorePanel = new ScorePanel(new Dimension(windowWidth, windowHeight));
        window.addGamePanelAndSetVisible(gamePanel, scorePanel);

    }

    @Override
    public void run() {
        int linesRemovedCounter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (gameRules.hasCrashedWithOtherCells()) {
                gameRules.stopActiveBlockAndMergeItWithBoard();

                linesRemovedCounter += gameRules.removeFilledLines();

                if (!gameRules.placeBlockOnGameBoard()) {
                    //Game Over
                    gameRules = new GameRules();
                    linesRemovedCounter = 0;
                }
            } else {
                gameRules.moveActiveBlockDown();
            }

            gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
            scorePanel.paintScoreBoard(linesRemovedCounter);
        }
    }


    public static GameRules getGameRules() {
        return gameRules;
    }


    public static void paintGameBoard() {
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
    }
}
