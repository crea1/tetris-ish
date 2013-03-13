package com.cozycoding.crea1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Keylistener listening on arrow strokes then returns text via callback.
 * @author Marius Kristensen
 */
public abstract class ArrowsKeyListener implements KeyListener {

    public abstract void onKeyPressed(String keyText);

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 37: onKeyPressed("<"); break;
            case 38: onKeyPressed("^"); break;
            case 39: onKeyPressed(">"); break;
            case 40: onKeyPressed("v"); break;
            default: onKeyPressed("");
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        onKeyPressed("");
    }
}
