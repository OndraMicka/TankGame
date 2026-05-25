package core;

import classResources.Animation;
import entities.Bullet;
import entities.Player;
import map.GameMap;
import map.MapLayoutPanel;
import classResources.ResourcesForMap;
import ui.GamePanel;

import javax.swing.*;

/**
 * Main game loop.
 * This thread handles the game logic, input, and drawing.
 * It runs at a frames per second (fps) and updates the game according to it.
 */
public class GameThread extends Thread {

    /**
     * Calculates and draws the game map and players.
     */
    private MapLayoutPanel mapLayoutPanel;

    private Player player1, player2;
    private GameMap gameMap;

    /** Frames per second for the game. */
    private int fps;

    /** Holds all the images for the map and players. */
    private ResourcesForMap resourcesForMap;

    /** The main game panel. */
    private GamePanel gamePanel;
    
    /** Manages key inputs from players. */
    private KeyInputManager keyInputManager;

    /**
     * Used for stopping the game loop when the game is over or the window is closed.
     */
    private volatile boolean running = true;


    public GameThread(GameMap map, GamePanel gamePanel, int fps) {
        this.fps = fps;
        player1 = map.getPlayer1();
        player2 = map.getPlayer2();
        player1.setFps(fps);
        player2.setFps(fps);

        resourcesForMap = new ResourcesForMap();
        
        this.keyInputManager = new KeyInputManager();
        this.gamePanel = gamePanel;

        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(keyInputManager);

        this.mapLayoutPanel = new MapLayoutPanel(map, player1, player2, resourcesForMap);
        this.gameMap = map;
    }

    /**
     * The game loop.
     * Divided into three main parts: input handling, game logic, and drawing.
     */
    @Override
    public void run() {
        SwingUtilities.invokeLater(this::initialize);
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());
        while (running) {
            handleInput();
            logic();
            SwingUtilities.invokeLater(this::draw);

            try {
                Thread.sleep(1000 / fps);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Loads the images for the game.
     */
    private void initialize() {
        resourcesForMap.setMap(gameMap.getImage());
        resourcesForMap.setPlayer1Body(new ImageIcon("res/tankBody-1.png.png").getImage());
        resourcesForMap.setPlayer1Turret(new ImageIcon("res/tankTurret.png").getImage());

        resourcesForMap.setPlayer2Turret(new ImageIcon("res/tankTurret.png").getImage());
        resourcesForMap.setPlayer2Body(new ImageIcon("res/tankBody.png").getImage());



    }

    /**
     * Checks what keys are pressed and executes methods on players.
     */
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
        if (player1Input.isBullet()) player1.fireBullet(gameMap, player1, player2);
        if (player1Input.isRocket()) player1.fireRocket(gameMap, player1, player2);
        
        // Player 2
        if (player2Input.isForward()) player2.accelerate();
        if (player2Input.isBackward()) player2.decelerate();
        if (player2Input.isRotateTankLeft()) player2.rotateTankLeft();
        if (player2Input.isRotateTankRight()) player2.rotateTankRight();
        if (player2Input.isRotateTurretLeft()) player2.rotateTurretLeft();
        if (player2Input.isRotateTurretRight()) player2.rotateTurretRight();
        if (player2Input.isBullet()) player2.fireBullet(gameMap,player2, player1);
        if (player2Input.isRocket()) player2.fireRocket(gameMap, player2, player1);
    }

    /**
     * Updates the game logic, like moving players and bullets.
     */
    private void logic() {

        player2.move(gameMap);
        player1.move(gameMap);
        for(Bullet bullet:gameMap.getBullets()){
            bullet.turn();
            bullet.move(gameMap);
        }
    }

    /**
     * Draws the game on the screen.
     */
    private void draw() {
        mapLayoutPanel.repaint();
        gamePanel.repaint();
    }

    public MapLayoutPanel getMapLayoutPanel() {
        return mapLayoutPanel;
    }
    
    public void stopGame() {
        running = false;
    }
}
