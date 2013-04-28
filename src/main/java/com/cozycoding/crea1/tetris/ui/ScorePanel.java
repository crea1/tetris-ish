package com.cozycoding.crea1.tetris.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * @author Marius Kristensen
 */
public class ScorePanel extends JPanel {

    private final JLabel linesRemoved;
    private final JLabel score;

    public ScorePanel(Dimension dimension) {
        setPreferredSize(dimension);
        setLayout(new GridLayout(0,2));
        JLabel scoreLabel = new JLabel("Score: ");
        score = new JLabel("");
        JLabel linesRemovedLabel = new JLabel("Lines removed");
        linesRemoved = new JLabel("");

        add(scoreLabel);
        add(score);
        add(linesRemovedLabel);
        add(linesRemoved);
    }


    public void paintScoreBoard(int linesRemovedCounter) {
        linesRemoved.setText(linesRemovedCounter + "");
        int s = 40 * linesRemovedCounter;
        score.setText(s + "");
    }
}
