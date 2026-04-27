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

//        String[] lang = allMaps.getArrayOfNames();
//
//        JComboBox<String> nameBox = new JComboBox<>(lang);

        add(Box.createVerticalGlue());
        JButton startButton = JButtonFactory.createMenuButton("START GAME", e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();

            GamePanel gamePanel = new GamePanel(mainPanel);
            mainPanel.add(gamePanel, "Game");
            cl.show(mainPanel, "Game");
        });



        //TODO: add panel for picking map
        JButton backButton = JButtonFactory.createMenuButton("BACK", e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "Menu");


        });
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(startButton);
        add(Box.createVerticalStrut(10));
        //add(nameBox);
        add(Box.createVerticalStrut(10));
        add(backButton);
        add(Box.createVerticalGlue());


//        mapLayoutPanel = new MapLayoutPanel(new AllMaps().getMap(0));
//        add(mapLayoutPanel);
    }
}
