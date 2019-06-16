package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A class to handle labels, goals, scores itself and a method to draw them.
 */
public class GameScore {

    private String[] labels;
    private int[] scores;
    private int[] goals;

    private static Font myBaseFont = new Font("Times", Font.BOLD, 16);

    public GameScore(String[] _labels, int[] _scores, int[] _goals) {
        labels = _labels;
        scores = _scores;
        goals = _goals;
    }

    public void paintScore(Graphics2D g, Rectangle area, int tileSize) {
        Font temp = g.getFont();
        g.setFont(myBaseFont);

        int firstHeight = area.y + area.height / 2;
        int heightSteps = (int) (1.2 * myBaseFont.getSize());
        if (labels.length > 1) { // more than one line of scores to paint
            firstHeight -= (int) (((labels.length - 1) / 2.) * heightSteps);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < labels.length; i++) {
            g.drawString(labels[i] + ": " + scores[i] + " / " + goals[i], area.x + area.width / tileSize - tileSize / 2,
                    firstHeight + i * heightSteps);
        }

        g.setFont(temp);
    }
}
