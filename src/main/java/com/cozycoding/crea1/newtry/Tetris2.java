package com.cozycoding.crea1.newtry;

/**
 * @author Marius Kristensen
 */
public class Tetris2 {

    public static void main(String[] args) {
        Game game = new Game();
        Thread t = new Thread(game);
        t.start();
    }
}
