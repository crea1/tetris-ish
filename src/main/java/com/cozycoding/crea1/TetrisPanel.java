package com.cozycoding.crea1;

import com.cozycoding.crea1.shapes.RectangleBlock;
import com.cozycoding.crea1.shapes.TetrisShape;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Panel where all the Tetris action happens
 *
 * @author Marius Kristensen
 */
public class TetrisPanel extends JPanel {

    private final Double width;
    private final Double height;
    public static TetrisShape activeTetrisShape;
    private List<TetrisShape> placedShapes;

    public TetrisPanel(Dimension dimension, TetrisShape tetrisShape) {
        setPreferredSize(dimension);
        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
        this.activeTetrisShape = tetrisShape;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setVisible(true);
        placedShapes = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g) {
        clear(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(activeTetrisShape.getColor());
        graphics2D.fill(activeTetrisShape.getShape());

        for (TetrisShape placedShape : placedShapes) {
            graphics2D.setColor(placedShape.getColor());
            graphics2D.fill(placedShape.getShape());
        }
    }


    private void clear(Graphics g) {
        super.paintComponent(g);
    }

    public boolean isAtBottom() {
        double v = activeTetrisShape.getY() + activeTetrisShape.getHeight();
        return (v == height);
    }

    public boolean hasBlockUnder() {
        double lowerY = activeTetrisShape.getY() + activeTetrisShape.getHeight();
        double x = activeTetrisShape.getX();
        double xx = activeTetrisShape.getX() + activeTetrisShape.getWidth();
        for (TetrisShape placedShape : placedShapes) {
            System.out.println("x = " + x + " xx = " + xx + " "+placedShape.getX()+", "+placedShape.getY());
            if (lowerY == placedShape.getY() && (x >= placedShape.getX() && x <=  placedShape.getX()+placedShape.getWidth()-1) ) {
                return true;
            }
        }
        return false;
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
            if (!isAtBottom() && !hasBlockUnder()) {
                int blockSize = 20;
                switch (keyEvent.getKeyCode()) {
                    case 37:
                        activeTetrisShape.setX(activeTetrisShape.getX() - blockSize);
                        break;
                    case 38:
                        activeTetrisShape = activeTetrisShape.rotateShape(activeTetrisShape);
                        break;
                    case 39:
                        activeTetrisShape.setX(activeTetrisShape.getX() + blockSize);
                        break;
                    case 40:
                        activeTetrisShape.setY(activeTetrisShape.getY() + blockSize);
                        break;
                }
            } else {
                placedShapes.add(activeTetrisShape);
                activeTetrisShape = new RectangleBlock(0, 0, 0, false);
            }
            repaint();
        }
    }
}
