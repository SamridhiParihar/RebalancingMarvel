package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ThanosGauntlet extends JPanel {

    private final List<Color> stones = new ArrayList<>();

    public ThanosGauntlet() {
        setPreferredSize(new Dimension(400, 600));
    }

    // Add a stone to the gauntlet
    public void addStone(Color color) {
        stones.add(color);
        repaint();
    }

    // Render the Gauntlet and Stones
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw Gauntlet (Golden Hand Shape)
        g2d.setColor(new Color(184, 134, 11));  // Gold
        g2d.fillOval(120, 400, 150, 150); // Palm
        g2d.fillRect(170, 300, 30, 100); // Thumb
        g2d.fillRect(130, 250, 20, 100); // Finger 1
        g2d.fillRect(160, 240, 20, 100); // Finger 2
        g2d.fillRect(190, 230, 20, 100); // Finger 3
        g2d.fillRect(220, 240, 20, 100); // Finger 4

        // Draw Infinity Stones (Circles on Fingers & Palm)
        int[][] stonePositions = {
                {135, 270}, // Finger 1 (Space)
                {165, 260}, // Finger 2 (Mind)
                {195, 250}, // Finger 3 (Reality)
                {225, 260}, // Finger 4 (Power)
                {180, 320}, // Palm (Time)
                {200, 450}  // Center (Soul)
        };

        for (int i = 0; i < stones.size(); i++) {
            g2d.setColor(stones.get(i));
            g2d.fillOval(stonePositions[i][0], stonePositions[i][1], 20, 20);
        }
    }

    // Main GUI Setup
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thanos' Gauntlet");
        ThanosGauntlet gauntlet = new ThanosGauntlet();

        frame.add(gauntlet);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add Stones one by one with delay
        Color[] stoneColors = {Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA, Color.GREEN, Color.ORANGE};

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

        JOptionPane.showMessageDialog(frame, "💥 SNAP! Half of the universe disappears!", "Thanos Snap", JOptionPane.WARNING_MESSAGE);
    }
}

