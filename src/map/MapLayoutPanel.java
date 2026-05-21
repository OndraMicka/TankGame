package map;

import classResources.ResourcesForMap;
import entities.Bullet;
import entities.Player;
import entities.TypeOfBullet;

import javax.swing.*;
import java.awt.*;

/**
 * Panel that draws the game map and all game objects.
 * Made by Gemini AI
 * Handles camera smoothing and zoom based on player positions so that both players are visible on the screen at all times.
 * The camera smoothly follows the midpoint between the two players and zooms in or out based on their distance.
 */
public class MapLayoutPanel extends JPanel {
    /** The game map to draw. */
    private GameMap gameMap;
    private Player player1;
    private Player player2;

    /** Scale factor to convert game map coords to pixels. */
    private int scaleFactor = 100;

    /** Images for tanks and the map. */
    private ResourcesForMap resources;

    /** Current camera x position (world coords). */
    private double currentCamX = 0;
    /** Current camera y position (world coords). */
    private double currentCamY = 0;
    /** Current camera zoom level. */
    private double currentZoom = 1.0;
    /** Speed of camera smoothing (0.01 to 0.1 recommended, can be lower). */
    private final double SMOOTHING = 0.005;

    /**
     * Creates the map panel.
     * @param gameMap the map to display
     * @param player1 first player
     * @param player2 second player
     * @param resources images for rendering players, map, bullets...
     */
    public MapLayoutPanel(GameMap gameMap, Player player1, Player player2, ResourcesForMap resources) {
        this.gameMap = gameMap;
        this.player1 = player1;
        this.player2 = player2;
        this.resources = resources;

        // Inicializace kamery na střed mezi hráče
        this.currentCamX = (player1.getX() + player2.getX()) / 2.0;
        this.currentCamY = (player1.getY() + player2.getY()) / 2.0;

        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    /**
     * Draws the map, players, and bullets.
     * Updates camera position and zoom smoothly.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // 1. VÝPOČET CÍLOVÝCH HODNOT (Už bez +0.5, protože hráč JE střed)
        double targetX = (player1.getX() + player2.getX()) / 2.0;
        double targetY = (player1.getY() + player2.getY()) / 2.0;

        double distWorldX = Math.abs(player1.getX() - player2.getX()) + 1.5;
        double distWorldY = Math.abs(player1.getY() - player2.getY()) + 1.5;

        double requiredWidthPx = distWorldX * scaleFactor + 400;
        double requiredHeightPx = distWorldY * scaleFactor + 400;

        double targetZoom = Math.min((double) panelWidth / requiredWidthPx, (double) panelHeight / requiredHeightPx);

        if (targetZoom > 2.0) targetZoom = 2.0;
        if (targetZoom < 0.2) targetZoom = 0.2;

        // 2. LERP
        currentCamX += (targetX - currentCamX) * SMOOTHING;
        currentCamY += (targetY - currentCamY) * SMOOTHING;
        currentZoom += (targetZoom - currentZoom) * SMOOTHING;

        // 3. TRANSFORMACE
        g2d.translate(panelWidth / 2.0, panelHeight / 2.0);
        g2d.scale(currentZoom, currentZoom);
        g2d.translate(-currentCamX * scaleFactor, -currentCamY * scaleFactor);

        // 4. MAPA (Kreslíme od 0,0, protože mapa začíná tam)
        g2d.drawImage(resources.getMap(), 0, 0, scaleFactor * gameMap.getWidth(), scaleFactor * gameMap.getHeight(), null);

        // 5. VYKRESLENÍ HRÁČŮ
        drawTank(g2d, player1.getX(), player1.getY(), player1.getRotation(), player1.getTurretRotation(), resources.getPlayer1Body(), resources.getPlayer1Turret());
        drawTank(g2d, player2.getX(), player2.getY(), player2.getRotation(), player2.getTurretRotation(), resources.getPlayer2Body(), resources.getPlayer2Turret());

        g2d.setColor(Color.RED);
        for(Bullet bullet:gameMap.getBullets()){
            if (bullet.getType().equals(TypeOfBullet.BASIC)) g2d.setColor(new Color(255, 246, 0));
            else if (bullet.getType().equals(TypeOfBullet.ROCKET)) g2d.setColor(new Color(83, 81, 81));
            g2d.fillOval((int)(bullet.getX()*scaleFactor)-5, (int)(bullet.getY()*scaleFactor)-5, 10, 10);
            //TODO add texture to bullets, rockets
        }

        repaint();
    }

    /**
     * Draws a tank with body and turret at the given position.
     * @param g2d the graphics context
     * @param x the x position
     * @param y the y position
     * @param bodyAngle the angle of the tank body
     * @param turretAngle the angle of the turret
     * @param bodyImg the body image
     * @param turretImg the turret image
     */
    private void drawTank(Graphics2D g2d, double x, double y, double bodyAngle, double turretAngle, Image bodyImg, Image turretImg) {
        java.awt.geom.AffineTransform old = g2d.getTransform();

        // centerX/Y je přesně pozice hráče (střed)
        double centerX = x * scaleFactor;
        double centerY = y * scaleFactor;

        g2d.translate(centerX, centerY);

        // --- 1. TĚLO ---
        g2d.rotate(Math.toRadians(bodyAngle));
        // Vykreslíme tak, aby 0,0 (střed) byl uprostřed obrázku
        g2d.drawImage(bodyImg, -scaleFactor / 2, -scaleFactor / 2, scaleFactor, scaleFactor, null);

        // --- 2. HLAVEŇ ---
        g2d.rotate(Math.toRadians(-bodyAngle)); // Zrušíme rotaci těla
        g2d.rotate(Math.toRadians(turretAngle)); // Aplikujeme rotaci věže

        // Používáme scaleFactor pro oba rozměry, aby nebyla hlaveň deformovaná
        g2d.drawImage(turretImg, -scaleFactor / 2, -scaleFactor / 2, scaleFactor, scaleFactor, null);

        g2d.setTransform(old);

        //TODO: pridat stopu za tank, vzdy se prida jedna a odebere posledni cast = fronta
    }
}
