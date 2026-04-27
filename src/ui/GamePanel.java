package ui;

import core.Game;
import core.GameMap;
import core.MapLayoutPanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JPanel mainPanel;

    private Game game;
    private MapLayoutPanel mapPanel;
    public GamePanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;




    }

    private void endGame(){
        //TODO: add button to end game, return to menu
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "SettingsMap");
        cl.removeLayoutComponent(this);
    }
}

