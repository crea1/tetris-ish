package com.cozycoding.crea1.shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * RectangleBlock shape
 *
 * @author Marius Kristensen
 */


public class RectangleBlock implements TetrisShape {
    private static final Color color = new Color(0xFF0056);
    private final double width = (double) 20;
    private final double height = (double) 80;
    private double x = 0;
    private double y = 0;
    private double rotation = 0;
    private RoundRectangle2D.Double rectangle;

    public RectangleBlock(double x, double y) {
        this.x = x;
        this.y = y;
        rectangle = new RoundRectangle2D.Double(x, y, width, height, 0, 0);
    }

    @Override
    public Shape getShape() {
        rectangle = new RoundRectangle2D.Double(x, y, width, height, 0, 0);
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
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }


    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

}
