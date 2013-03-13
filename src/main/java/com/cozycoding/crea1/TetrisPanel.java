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

    private final Double width;
    private final Double height;
    private TetrisShape activeTetrisShape;

    public TetrisPanel(Dimension dimension, TetrisShape tetrisShape) {
        setPreferredSize(dimension);
        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
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
        double x = activeTetrisShape.getX();
        double y = activeTetrisShape.getY();
        Double height = activeTetrisShape.getHeight();
        //todo find another way to rotate
        graphics2D.rotate(Math.toRadians(activeTetrisShape.getRotation()), x + width / 2, y + height / 2);
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
            if (!isAtBottom()) {
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
            }

            System.out.println("keyEvent = " + isAtBottom());
            repaint();
        }
    }

    private boolean isAtBottom() {
        double v = activeTetrisShape.getY() + activeTetrisShape.getHeight();
        return (v == height);

    }

}
