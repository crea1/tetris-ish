package com.cozycoding.crea1.tetris.ui;

import com.cozycoding.crea1.tetris.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            //
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    Game.getGameRules().moveActiveBlockLeft();
                    break;
                case KeyEvent.VK_UP:
                    Game.getGameRules().rotateActiveBlock();
                    break;
                case KeyEvent.VK_RIGHT:
                    Game.getGameRules().moveActiveBlockRight();
                    break;
                case KeyEvent.VK_DOWN:
                    Game.getGameRules().moveActiveBlockDown();
                    break;
            }
            Game.paintGameBoard();
        }
}