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
    private final double shortSide = (double) 20;
    private final double longSide = (double) 80;
    private double height = 0;
    private double width = 0;
    private double x = 0;
    private double y = 0;
    private int rotation = 0;
    private boolean sideWays;
    private RoundRectangle2D.Double rectangle;

    public RectangleBlock(double x, double y, int rotation, boolean isSideWays) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        sideWays = isSideWays;
        rectangle =  createRectangle(x, y, isSideWays);
    }

    private RoundRectangle2D.Double createRectangle(double x, double y, boolean isSideWays) {
        RoundRectangle2D.Double rectangle;
        if (isSideWays) {
            rectangle = new RoundRectangle2D.Double(x, y, longSide, shortSide, 0, 0);
        } else {
            rectangle = new RoundRectangle2D.Double(x, y, shortSide, longSide, 0, 0);
        }
        return rectangle;
    }

    @Override
    public TetrisShape rotateShape(TetrisShape rectangleBlock) {
        RectangleBlock block;
        if (rectangleBlock.getRotation() == 0 || rectangleBlock.getRotation() == 180) {
            block = new RectangleBlock(rectangleBlock.getX(), rectangleBlock.getY(), 90, true);
        } else {
            block = new RectangleBlock(rectangleBlock.getX(), rectangleBlock.getY(), 0, false);
        }
        return block;
    }

    @Override
    public Shape getShape() {
        rectangle = createRectangle(x, y, sideWays);
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
    public double getHeight() {
        if (sideWays) {
            return shortSide;
        }
        return longSide;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
