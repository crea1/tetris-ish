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
                    Game.getGameRules().moveActiveBlockLeft();
                    break;
                case 38:
                    //TODO Rotate block
                    break;
                case 39:
                    Game.getGameRules().moveActiveBlockRight();
                    break;
                case 40:
                    Game.getGameRules().moveActiveBlockDown();
                    break;
            }
            Game.paintGameBoard();
        }
}