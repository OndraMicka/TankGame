package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JButtonFactory {

    public static JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.setForeground(new Color(189, 189, 189));
        button.setBackground(new Color(0, 0, 0));
        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setPreferredSize(new java.awt.Dimension(100, 50));
        return button;
    }
}
