package ui;


import core.AllMaps;
import core.GameMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeforeGameSettingsPanel extends JPanel {
    private AllMaps allMaps;

    private JPanel mainPanel;

    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public BeforeGameSettingsPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        allMaps = new AllMaps();

        setBackground(new Color(0, 0, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        String[] lang = allMaps.getArrayOfNames();
        JComboBox<String> nameBox = new JComboBox<>(lang);
        nameBox.setMaximumSize(new Dimension(400, 60));
        nameBox.setPreferredSize(new Dimension(300, 60));
        nameBox.setForeground(new Color(189, 189, 189));
        nameBox.setBackground(new Color(42, 66, 31));
        nameBox.setFont(new Font("Arial", Font.BOLD, 20));
        nameBox.setFocusable(false);
        nameBox.setRequestFocusEnabled(false);
        nameBox.setOpaque(true);

        nameBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setBackground(new Color(42, 66, 31));
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                return button;
            }
        });


        add(Box.createVerticalGlue());
        JButton startButton = JButtonFactory.createMenuButton("START GAME", e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();

            GamePanel gamePanel = new GamePanel(mainPanel,allMaps.getMap((String)nameBox.getSelectedItem()));
            mainPanel.add(gamePanel, "Game");
            cl.show(mainPanel, "Game");
        });

        JButton backButton = JButtonFactory.createMenuButton("BACK", e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "Menu");
        });
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(startButton);
        add(Box.createVerticalStrut(10));
        add(nameBox);
        add(Box.createVerticalStrut(10));
        add(backButton);
        add(Box.createVerticalGlue());


//        mapLayoutPanel = new MapLayoutPanel(new AllMaps().getMap(0));
//        add(mapLayoutPanel);
    }
}
