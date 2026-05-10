package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Factory for creating styled buttons for the game.
 * Creates buttons with consistent style.
 */
public class JButtonFactory {

    /**
     * Creates a menu button with large text.
     * @param text the button label
     * @param action what to do when clicked
     * @return the styled button
     */
    public static JButton createMenuButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        button.setFocusPainted(false);
        button.setBorderPainted(false);;
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.setForeground(new Color(189, 189, 189));
        button.setBackground(new Color(42, 66, 31));
        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setPreferredSize(new java.awt.Dimension(100, 50));
        return button;
    }

    /**
     * Creates a settings button with smaller text.
     * @param text the button label
     * @param action what to do when clicked
     * @return the styled button
     */
    public static JButton createSettingsButton(String text,ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        //button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.setForeground(new Color(189, 189, 189));
        button.setBackground(new Color(42, 66, 31));

        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));

        return button;
    }
}
