package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MarvelGauntlet extends JPanel {

    private final List<Color> stones = new ArrayList<>();
    private boolean snapEffect = false;

    public MarvelGauntlet() {
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.BLACK);
    }

    // Add a stone to the gauntlet
    public void addStone(Color color) {
        stones.add(color);
        repaint();
    }

    // Trigger the snap effect
    public void snap() {
        snapEffect = true;
        repaint();
    }

    // Render the Gauntlet and Stones
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw Gauntlet (Golden Hand Shape with Gradient)
        GradientPaint goldGradient = new GradientPaint(0, 0, new Color(255, 215, 0), 0, 600, new Color(184, 134, 11));
        g2d.setPaint(goldGradient);

        // Palm
        g2d.fill(new RoundRectangle2D.Double(250, 400, 100, 150, 50, 50));

        // Fingers
        g2d.fill(new RoundRectangle2D.Double(200, 300, 30, 120, 20, 20)); // Thumb
        g2d.fill(new RoundRectangle2D.Double(250, 250, 20, 150, 20, 20)); // Finger 1
        g2d.fill(new RoundRectangle2D.Double(280, 240, 20, 150, 20, 20)); // Finger 2
        g2d.fill(new RoundRectangle2D.Double(310, 250, 20, 150, 20, 20)); // Finger 3
        g2d.fill(new RoundRectangle2D.Double(340, 300, 30, 120, 20, 20)); // Finger 4

        // Draw Infinity Stones (Glowing Circles)
        int[][] stonePositions = {
                {260, 270}, // Finger 1 (Space)
                {290, 260}, // Finger 2 (Mind)
                {320, 270}, // Finger 3 (Reality)
                {350, 320}, // Finger 4 (Power)
                {280, 450}, // Palm (Time)
                {300, 500}  // Center (Soul)
        };

        for (int i = 0; i < stones.size(); i++) {
            // Stone Glow Effect
            g2d.setColor(new Color(stones.get(i).getRed(), stones.get(i).getGreen(), stones.get(i).getBlue(), 100));
            g2d.fill(new Ellipse2D.Double(stonePositions[i][0] - 10, stonePositions[i][1] - 10, 40, 40));

            // Stone
            g2d.setColor(stones.get(i));
            g2d.fill(new Ellipse2D.Double(stonePositions[i][0], stonePositions[i][1], 20, 20));
        }

        // Snap Effect (Radial Gradient)
        if (snapEffect) {
            RadialGradientPaint snapGradient = new RadialGradientPaint(
                    300, 550, 300,
                    new float[]{0.0f, 1.0f},
                    new Color[]{new Color(255, 255, 255, 100), new Color(255, 255, 255, 0)}
            );
            g2d.setPaint(snapGradient);
            g2d.fill(new Ellipse2D.Double(0, 0, 600, 800));
        }
    }

    // Main GUI Setup
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thanos' Gauntlet");
        MarvelGauntlet gauntlet = new MarvelGauntlet();

        frame.add(gauntlet);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add Stones one by one with delay
        Color[] stoneColors = {
                new Color(0, 102, 255),   // Space (Blue)
                new Color(255, 255, 0),   // Mind (Yellow)
                new Color(255, 0, 0),     // Reality (Red)
                new Color(153, 0, 255),   // Power (Purple)
                new Color(0, 204, 0),     // Time (Green)
                new Color(255, 153, 51)   // Soul (Orange)
        };

        for (Color color : stoneColors) {
            try {
                Thread.sleep(1000); // Delay to simulate collection
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gauntlet.addStone(color);
        }

        // Simulate Snap Effect
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gauntlet.snap();

        JOptionPane.showMessageDialog(frame, "💥 SNAP! Half of the universe disappears!", "Thanos Snap", JOptionPane.WARNING_MESSAGE);
    }
}