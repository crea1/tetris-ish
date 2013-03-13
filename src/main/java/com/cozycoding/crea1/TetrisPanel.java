package com.cozycoding.crea1;

import com.cozycoding.crea1.shapes.TetrisShape;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Panel where all the Tetris action happens
 *
 * @author Marius Kristensen
 */
public class TetrisPanel extends JPanel {

    private TetrisShape activeTetrisShape;

    public TetrisPanel(Dimension dimension, TetrisShape tetrisShape) {
        setPreferredSize(dimension);
        this.activeTetrisShape = tetrisShape;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        clear(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Double width = activeTetrisShape.getWidth();
        double posX = activeTetrisShape.getX();
        double posY = activeTetrisShape.getY();
        Double height = activeTetrisShape.getHeight();
        graphics2D.rotate(Math.toRadians(activeTetrisShape.getRotation()), posX + width/2, posY + height/2);
        graphics2D.setColor(activeTetrisShape.getColor());
        graphics2D.fill(activeTetrisShape.getShape());
    }


    private void clear(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Keylisteners
     */
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            //
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            switch (keyEvent.getKeyCode()) {
                case 37:
                    activeTetrisShape.setX(activeTetrisShape.getX() - 20);
                    break;
                case 38:
                    activeTetrisShape.setRotation(activeTetrisShape.getRotation() + 90);
                    break;
                case 39:
                    activeTetrisShape.setX(activeTetrisShape.getX() + 20);
                    break;
                case 40:
                    activeTetrisShape.setY(activeTetrisShape.getY() + 20);
                    break;
            }
            repaint();
        }
    }

}
