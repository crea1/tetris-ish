package com.cozycoding.crea1.shapes;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * RectangleBlock shape
 *
 * @author Marius Kristensen
 */


public class RectangleBlock implements TetrisShape {
    private static final Color color = new Color(0xFF0056);
    private final Double width = (double) 20;
    private final Double height = (double) 80;
    private Double posX = (double) 0;
    private Double posY = (double) 0;
    private RoundRectangle2D.Double rectangle;

    public RectangleBlock() {
        rectangle = new RoundRectangle2D.Double(posX, posY, width, height, 0, 0);
    }

    @Override
    public Shape getShape() {
        rectangle = new RoundRectangle2D.Double(posX, posY, width, height, 0, 0);
        return rectangle;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void onRightKeyPressedEvent() {
        posX += 5;
    }

    @Override
    public void onLeftKeyPressedEvent() {
        posX -= 5;
    }

    @Override
    public void onUpKeyPressedEvent() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onDownKeyPressedEvent() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
