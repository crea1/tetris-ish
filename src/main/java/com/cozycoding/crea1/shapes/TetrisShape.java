package com.cozycoding.crea1.shapes;

import java.awt.*;

/**
 * @author Marius Kristensen
 */
public abstract interface TetrisShape {

    Shape getShape();

    Color getColor();

    double getRotation();

    double getX();

    void setX(double posX);

    double getY();

    void setY(double posY);

    Double getWidth();

    Double getHeight();

    void setRotation(double rotation);
}
