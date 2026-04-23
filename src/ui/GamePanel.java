package ui;

import core.AllMaps;
import core.MapLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private MapLayoutPanel mapLayoutPanel;

    //TODO: add panel for picking map and player health
    public GamePanel(JPanel mainPanel) {
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());

        mapLayoutPanel = new MapLayoutPanel(new AllMaps().getMap(0));
        add(mapLayoutPanel);
    }
}
