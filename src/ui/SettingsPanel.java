package ui;

import core.ConfigManager;
import core.Settings;
import ui.rowsSettings.CheckBoxRow;
import ui.rowsSettings.KeyButtonRow;
import ui.rowsSettings.LabelRow;
import ui.rowsSettings.TextFieldRow;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SettingsPanel extends JPanel {
    //can switch panels with card layout, so we need reference to main panel
    private JPanel mainPanel;


    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JPanel sidePanelEast;
    private JPanel sidePanelWest;
    private JPanel midlePanel;
    private JPanel buttonsPanel;
    private JButton buttonBack;
    private JButton buttonReset;
    private JButton buttonApply;

    private JPanel container; //panel in scrollPane

    public SettingsPanel(JPanel mainPanel) {
        this.setLayout(new BorderLayout());
        this.add(contentPane, BorderLayout.CENTER);
        this.mainPanel = mainPanel;
        addButtonsToContainer();

        //container.add(Box.createVerticalGlue());


        container.revalidate();
        container.repaint();
    }

    private void addButtonsToContainer() {
        Settings.PlayerSettings player1Settings = ConfigManager.getSettings().getPlayer1();
        Settings.PlayerSettings player2Settings = ConfigManager.getSettings().getPlayer2();

        container.add(new LabelRow("Player 1 Settings"));
        container.add(new TextFieldRow("Name", player1Settings.getPlayerName()));
        container.add(new KeyButtonRow("Move Forward", player1Settings.getMoveForwardKey()));
        container.add(new KeyButtonRow("Move Backward", player1Settings.getMoveBackKey()));
        container.add(new KeyButtonRow("Turn Left", player1Settings.getTurnLeftKey()));
        container.add(new KeyButtonRow("Turn Right", player1Settings.getTurnRightKey()));
        container.add(new KeyButtonRow("Fire", player1Settings.getFireKey()));

        container.add(new LabelRow("Player 2 Settings"));
        container.add(new TextFieldRow("Name", player2Settings.getPlayerName()));
        container.add(new KeyButtonRow("Move Forward", player2Settings.getMoveForwardKey()));
        container.add(new KeyButtonRow("Move Backward", player2Settings.getMoveBackKey()));
        container.add(new KeyButtonRow("Turn Left", player2Settings.getTurnLeftKey()));
        container.add(new KeyButtonRow("Turn Right", player2Settings.getTurnRightKey()));
        container.add(new KeyButtonRow("Fire", player2Settings.getFireKey()));
    }

    private void createUIComponents() {
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);

        buttonsPanel = new JPanel();

        buttonReset = JButtonFactory.createSettingsButton("Reset", e -> {
            ConfigManager.resetToDefaultSettings("defaultSettings.json", "settings.json");
            container.removeAll();
            addButtonsToContainer();
            this.repaint();
            this.revalidate();
            this.requestFocusInWindow();
        });
        buttonApply = JButtonFactory.createSettingsButton("Apply", e -> {
            ConfigManager.saveGameSettingsResources("settings.json");
            this.repaint();
            this.requestFocusInWindow();
        });
        buttonBack = JButtonFactory.createSettingsButton("Back", e -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "Menu");
            this.requestFocusInWindow();
        });

        buttonsPanel.add(buttonBack);
        buttonsPanel.add(buttonReset);
        buttonsPanel.add(buttonApply);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);

    }

    @Override
    public void repaint(Rectangle r) {
        super.repaint(r);

    }
}