package ui;

import javax.swing.*;
import java.awt.*;

/**
 * The main menu panel.
 * Shows START, SETTINGS, and END button.
 */
public class MenuPanel extends JPanel {
    /** The main panel for switching between screens(Card layout) */
    private final JPanel mainPanel;

    /**
     * Creates the menu panel.
     * @param mainPanel the main panel to switch screens with
     */
    public MenuPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        setBackground(new Color(0, 0, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addButtons();
    }

    /**
     * Adds the menu buttons.
     */
    private void addButtons() {
        add(Box.createVerticalGlue());
        JButton startButton = JButtonFactory.createMenuButton("START", e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "SettingsMap");
        });
        JButton settingsButton = JButtonFactory.createMenuButton("SETTINGS", e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Settings");
        });
        JButton endButton = JButtonFactory.createMenuButton("END", e -> {
                SwingUtilities.invokeLater(()->System.exit(0));
        });
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        endButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(startButton);
        add(Box.createVerticalStrut(10));
        add(settingsButton);
        add(Box.createVerticalStrut(10));
        add(endButton);
        add(Box.createVerticalGlue());
    }

}
