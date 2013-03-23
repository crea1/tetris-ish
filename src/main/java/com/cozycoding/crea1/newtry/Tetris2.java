package com.cozycoding.crea1.newtry;

import com.cozycoding.crea1.newtry.Blocks.SquareBlock;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        gameRules = new GameRules();
        gameRules.placeBlockOnGameBoard(new SquareBlock());
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        gamePanel = new GamePanel(new Dimension(windowWidth, windowHeight));
        gamePanel.addKeyListener(new TAdapter());
        gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
        window.add(gamePanel);

    }
    private static class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            //
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case 37:
                    gameRules.moveActiveBlockLeft();
                    break;
                case 38:
                    //TODO Rotate block
                    break;
                case 39:
                    gameRules.moveActiveBlockRight();
                    break;
                case 40:
                    gameRules.moveActiveBlockDown();
                    break;
            }
            gamePanel.paintGameBoard(gameRules.getGameBoard(), gameRules.getActiveBlock());
        }
    }

}
