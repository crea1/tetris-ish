package com.cozycoding.crea1.newtry;

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
                case 37:
                    Tetris2.getGameRules().moveActiveBlockLeft();
                    break;
                case 38:
                    //TODO Rotate block
                    break;
                case 39:
                    Tetris2.getGameRules().moveActiveBlockRight();
                    break;
                case 40:
                    Tetris2.getGameRules().moveActiveBlockDown();
                    break;
            }
            Tetris2.paintGameBoard();
        }
}