package core;

import entities.Bullet;
import entities.Player;
import map.GameMap;
import map.MapLayoutPanel;
import map.ResourcesForMap;
import ui.GamePanel;

import javax.swing.*;

public class GameThread extends Thread {
    private MapLayoutPanel mapLayoutPanel;
    private Player player1, player2;
    private GameMap gameMap;

    private int fps;

    private ResourcesForMap resourcesForMap;

    private GamePanel gamePanel;
    
    private KeyInputManager keyInputManager;

    public GameThread(GameMap map, GamePanel gamePanel, int fps) {
        this.fps = fps;
        player1 = map.getPlayer1();
        player2 = map.getPlayer2();
        player1.setFps(fps);
        player2.setFps(fps);

        resourcesForMap = new ResourcesForMap();
        
        this.keyInputManager = new KeyInputManager();
        this.gamePanel = gamePanel;
        
        // Nastavit fokus pro klávesnici
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(keyInputManager);

        this.mapLayoutPanel = new MapLayoutPanel(map, player1, player2, resourcesForMap);
        this.gameMap = map;
    }

    @Override
    public void run() {
        initialize();
        gamePanel.requestFocus();
        while (true) {
            handleInput();
            logic();
            draw();

            try {
                Thread.sleep(1000 / fps);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void initialize() {
        resourcesForMap.setMap(gameMap.getImage());
        resourcesForMap.setPlayer1Body(new ImageIcon("res/tankBody.png").getImage());
        resourcesForMap.setPlayer1Turret(new ImageIcon("res/tankTurret.png").getImage());

        resourcesForMap.setPlayer2Turret(new ImageIcon("res/tankTurret.png").getImage());
        resourcesForMap.setPlayer2Body(new ImageIcon("res/tankBody.png").getImage());


    }

    private void handleInput() {
        KeyInputManager.PlayerInput player1Input = keyInputManager.getPlayer1Input();
        KeyInputManager.PlayerInput player2Input = keyInputManager.getPlayer2Input();
        
        // Player 1
        if (player1Input.isForward()) player1.accelerate();
        if (player1Input.isBackward()) player1.decelerate();
        if (player1Input.isRotateTankLeft()) player1.rotateTankLeft();
        if (player1Input.isRotateTankRight()) player1.rotateTankRight();
        if (player1Input.isRotateTurretLeft()) player1.rotateTurretLeft();
        if (player1Input.isRotateTurretRight()) player1.rotateTurretRight();
        if (player1Input.isBullet()) player1.fire(gameMap, entities.TypeOfBullet.BASIC, player1, player2);
        if (player1Input.isRocket()) player1.fire(gameMap, entities.TypeOfBullet.ROCKET, player1, player2);
        //TODO rocket, bullet
        
        // Player 2
        if (player2Input.isForward()) player2.accelerate();
        if (player2Input.isBackward()) player2.decelerate();
        if (player2Input.isRotateTankLeft()) player2.rotateTankLeft();
        if (player2Input.isRotateTankRight()) player2.rotateTankRight();
        if (player2Input.isRotateTurretLeft()) player2.rotateTurretLeft();
        if (player2Input.isRotateTurretRight()) player2.rotateTurretRight();
        if (player2Input.isBullet()) player2.fire(gameMap, entities.TypeOfBullet.BASIC,player2, player1);
        if (player2Input.isRocket()) player2.fire(gameMap, entities.TypeOfBullet.ROCKET, player2, player1);
        //TODO rocket, bullet
    }

    private void logic() {

        player2.move(gameMap);
        player1.move(gameMap);
        for(Bullet bullet:gameMap.getBullets()){
            bullet.turn();
            bullet.move(gameMap);
        }
    }

    private void draw() {
        mapLayoutPanel.repaint();
    }

    public MapLayoutPanel getMapLayoutPanel() {
        return mapLayoutPanel;
    }
}
