package ui;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class GamePanel extends JPanel {
    public GamePanel(JPanel mainPanel) {
        setLayout(null);
        setBackground(new java.awt.Color(56, 255, 0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rect = new Rectangle(50, 50, 100, 100);
        g2d.setColor(Color.RED);
        g2d.fill(rect);

        Rectangle2D rect2 = new Rectangle(100, 100, 100, 100);
        g2d.setColor(Color.YELLOW);
        g2d.fill(rect2);

        if(rect.intersects(rect2)) {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Collision Detected!", 50, 200);

        }
    }
}
