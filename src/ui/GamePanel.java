package ui;

import core.*;
import map.GameMap;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JPanel mainPanel;


    public GamePanel(JPanel mainPanel, GameMap gameMap) {
        this.mainPanel = mainPanel;
        GameThread thread = new GameThread(gameMap, this,60);
        thread.start();
        this.setLayout(new BorderLayout());
        this.add(thread.getMapLayoutPanel(), BorderLayout.CENTER);






    }

    private void endGame(){
        //TODO: add button to end game, return to menu
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, "SettingsMap");
        cl.removeLayoutComponent(this);
    }
}

