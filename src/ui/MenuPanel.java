package ui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final JPanel mainPanel;
    public MenuPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        setBackground(new Color(67, 67, 67));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addButtons();
    }
    private void addButtons() {
        add(Box.createVerticalGlue());
        JButton startButton = JButtonFactory.createMenuButton("START", e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Game");
        });
        JButton settingsButton = JButtonFactory.createMenuButton("SETTINGS", e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Settings");
        });
        JButton endButton = JButtonFactory.createMenuButton("END", e -> {
                System.exit(0);
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
