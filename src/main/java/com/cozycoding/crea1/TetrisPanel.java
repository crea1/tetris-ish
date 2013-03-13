package com.cozycoding.crea1;

import com.cozycoding.crea1.shapes.TetrisShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Panel where all the Tetris action happens
 *
 * @author Marius Kristensen
 */
public class TetrisPanel extends JPanel {


    private static final Color skyColor = new Color(0x87CEEB);
    private Double width;
    private Double height;
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
                    activeTetrisShape.onLeftKeyPressedEvent();
                    break;
                case 38:
                    activeTetrisShape.onUpKeyPressedEvent();
                    break;
                case 39:
                    activeTetrisShape.onRightKeyPressedEvent();
                    break;
                case 40:
                    activeTetrisShape.onDownKeyPressedEvent();
                    break;
            }
            repaint();
        }
    }

}
