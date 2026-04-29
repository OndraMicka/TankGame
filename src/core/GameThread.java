package core;

import ui.GamePanel;

import javax.swing.*;
import java.util.Random;

public class GameThread extends Thread {
    private MapLayoutPanel mapLayoutPanel;
    private Player player1, player2;
    private GameMap gameMap;

    private ResourcesForMap resourcesForMap;

    private GamePanel gamePanel;

    public GameThread(GameMap map, GamePanel gamePanel) {
        player1 = map.getPlayer1();
        player2 = map.getPlayer2();
        resourcesForMap = new ResourcesForMap();


        this.mapLayoutPanel = new MapLayoutPanel(map, player1, player2, resourcesForMap);
        this.gameMap = map;

        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        initialize();
        while (true) {
            handleInput();
            logic();
            draw();
        }
    }

    private void initialize() {
        resourcesForMap.setMap(gameMap.getImage());
        resourcesForMap.setPlayer1Body(new ImageIcon("res/tankBody.png").getImage());
        resourcesForMap.setPlayer2Body(new ImageIcon("res/tankBody.png").getImage());
        resourcesForMap.setPlayer1Turret(new ImageIcon("res/tankTurret.png").getImage());
        resourcesForMap.setPlayer2Turret(new ImageIcon("res/tankTurret.png").getImage());
    }

    private void handleInput() {
    }

    private void logic() {
        player1.setX(player1.getX() +0.05);
        player2.setY(player2.getY() -0.02);
        player2.setY(player2.getY() +0.05);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void draw() {
        mapLayoutPanel.repaint();
    }

    public MapLayoutPanel getMapLayoutPanel() {
        return mapLayoutPanel;
    }
}
