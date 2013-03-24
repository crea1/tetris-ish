package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.Cell;
import com.cozycoding.crea1.tetris.blocks.TetrisBlock;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius Kristensen
 */
public class GamePanel extends JPanel {

    private final Double height;
    private final Double width;
    private final Double cellSize;
    private List<RoundRectangle2D> cells = new ArrayList<>();
    private List<RoundRectangle2D> board = new ArrayList<>();
    private static final Color color = new Color(0xFF0056);
    private static final Color emptyCells = new Color(0x3377FF);

    public GamePanel(Dimension dimension) {
        setPreferredSize(dimension);
        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
        this.cellSize = dimension.getWidth() / 10;
        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        clear(g);
        Graphics2D graphics2D = (Graphics2D) g;

        for (RoundRectangle2D cell : board) {
            graphics2D.setColor(emptyCells);
            graphics2D.fill(cell);
        }

        for (RoundRectangle2D cell : cells) {
            graphics2D.setColor(color);
            graphics2D.fill(cell);
        }
    }

    public void paintGameBoard(Cell[][] gameBoard, TetrisBlock activeBlock) {
        board.removeAll(board);
        cells.removeAll(cells);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                Cell cell = gameBoard[i][j];
                board.add(createRectangle(cell.getX(), cell.getY()));
            }
        }
        for (Cell cell : activeBlock.getShape()) {
            cells.add(createRectangle(cell.getX(), cell.getY()));
        }
        repaint();
    }

    private void clear(Graphics g) {
        super.paintComponent(g);
    }

    private RoundRectangle2D.Double createRectangle(double x, double y) {
        return new RoundRectangle2D.Double(x * cellSize, y * cellSize, cellSize, cellSize, 0, 0);
    }
}
