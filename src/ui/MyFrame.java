package ui;

import javax.swing.*;
import java.awt.*;

/**
 * The main game window.
 * Sets up the frame and switches between different panels (menu, settings, game).
 */
public class MyFrame extends JFrame {
    /** The main panel holding all screens. */
    private JPanel panel;
    /** The layout for switching between panels. */
    private CardLayout cardLayout;

    /**
     * Creates the main game window.
     */
    public MyFrame() {
        setTitle("Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 300));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel = new JPanel();
        panel.setBackground(Color.GREEN);
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        add(panel);

        addPanels();

        setVisible(true);
    }

    /**
     * Adds all the panels to the main panel with card layout.
     */
    private void addPanels() {
        MenuPanel menuPanel = new MenuPanel(panel);
        panel.add(menuPanel, "Menu");

        SettingsPanel settingsPanel = new SettingsPanel(panel);
        panel.add(settingsPanel, "Settings");

        BeforeGameSettingsPanel beforeGameSettingsPanel = new BeforeGameSettingsPanel(panel);
        panel.add(beforeGameSettingsPanel, "SettingsMap");


        cardLayout = (CardLayout) panel.getLayout();
        cardLayout.show(panel, "Menu");
    }
}
