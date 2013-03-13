package com.cozycoding.crea1.shapes;

import java.awt.*;

/**
 * @author Marius Kristensen
 */
public abstract interface TetrisShape {

    void onRightKeyPressedEvent();

    void onLeftKeyPressedEvent();

    void onUpKeyPressedEvent();

    void onDownKeyPressedEvent();

    Shape getShape();

    Color getColor();

    double getRotation();

    double getPosX();

    void setPosX(double posX);

    double getPosY();

    void setPosY(double posY);

    Double getWidth();

    Double getHeight();
}
