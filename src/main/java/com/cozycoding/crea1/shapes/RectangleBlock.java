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
    private double posX = 0;
    private double posY = 0;
    private double rotation = 0;
    private RoundRectangle2D.Double rectangle;

    public RectangleBlock(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
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
    public double getRotation() {
        return rotation;
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
        rotation += 90;
    }

    @Override
    public void onDownKeyPressedEvent() {
        rotation -= 90;
    }


    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

}
