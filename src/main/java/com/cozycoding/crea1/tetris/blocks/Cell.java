package com.cozycoding.crea1.tetris.blocks;

import java.awt.Color;

/**
 * @author Marius Kristensen
 */
public class Cell {
    private boolean isFilled;
    private int x;
    private int y;
    private Color color = new Color(0xFFFFFF);

    public Cell(boolean filled, int x, int y, Color color) {
        isFilled = filled;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Cell(boolean filled, int x, int y) {
        isFilled = filled;
        this.x = x;
        this.y = y;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
