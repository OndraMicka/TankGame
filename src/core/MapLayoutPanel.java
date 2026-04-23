package core;

import blocksOnMap.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MapLayoutPanel extends JPanel {
    private GameMap gameMap;
    private GameMapPanel gameMapPanel;

    private int scaleFactor;
    private int maxScaleFactor;

    public MapLayoutPanel(GameMap gameMap) {
        scaleFactor = 50;
        this.gameMap = gameMap;
        this.setLayout(null);
        gameMapPanel = new GameMapPanel();
        this.add(gameMapPanel);
    }



    private class GameMapPanel extends JPanel {
        public GameMapPanel() {
            setLayout(null);
            setSize(gameMap.getWidth()*scaleFactor, gameMap.getHeight()*scaleFactor);
            setVisible(true);
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;


            for (int y = 0; y < gameMap.getHeight(); y++) {
                for (int x = 0; x < gameMap.getWidth(); x++) {
                    if(gameMap.getMapArray()[x][y] instanceof Wall){
                        g2d.setColor(Color.black);
                        g2d.fillRect(x*scaleFactor, y*scaleFactor, scaleFactor, scaleFactor);
                    }
                }
            }
        }
    }
}
