package com.cozycoding.crea1.shapes;

import java.awt.Color;
import java.awt.Shape;

/**
 * @author Marius Kristensen
 */
public abstract interface TetrisShape {

    Shape getShape();

    TetrisShape rotateShape(TetrisShape rectangleBlock);

    Color getColor();

    double getRotation();

    double getX();

    void setX(double posX);

    double getY();

    void setY(double posY);

    double getWidth();

    double getHeight();
}
