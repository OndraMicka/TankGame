package ui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JPanel panel;
    private CardLayout cardLayout;

    public MyFrame() {
        setTitle("Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 300));

        panel = new JPanel();
        panel.setBackground(Color.GREEN);
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        add(panel);

        addPanels();

        setVisible(true);
    }

    private void addPanels() {
        MenuPanel menuPanel = new MenuPanel(panel);
        panel.add(menuPanel, "Menu");

        SettingsPanel settingsPanel = new SettingsPanel(panel);
        panel.add(settingsPanel, "Settings");

        GamePanel gamePanel = new GamePanel(panel);
        panel.add(gamePanel, "Game");

        cardLayout = (CardLayout) panel.getLayout();
        cardLayout.show(panel, "Menu");
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanel() {
        return panel;
    }
}
