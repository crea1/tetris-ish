package com.cozycoding.crea1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Draws the "world".. that is, a
 *
 * @author Marius Kristensen
 */
public class TetrisPanel extends JPanel {
    private static final Color skyColor = new Color(0x87CEEB);
    private Double width;
    private Double height;
    public TetrisPanel(Dimension dimension) {
        setPreferredSize(dimension);
        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
    }

    @Override
    public void paintComponent(Graphics g) {
        clear(g);
        Graphics2D graphics2D = (Graphics2D) g;
        drawSky(graphics2D);
    }

    private void drawSky(Graphics2D g) {
        g.setColor(skyColor);
        g.fill(new RoundRectangle2D.Double(0, 0, width, height, 0, 0));
    }


    private void clear(Graphics g) {
        super.paintComponent(g);
    }
}
