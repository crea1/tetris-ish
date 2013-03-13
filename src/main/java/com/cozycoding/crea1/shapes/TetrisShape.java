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
}
