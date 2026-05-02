package map;

import entities.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Třída Vygenerována od gemini.
 */
public class MapLayoutPanel extends JPanel {
    private GameMap gameMap;
    private Player player1;
    private Player player2;
    private int scaleFactor = 100;

    private ResourcesForMap resources;

    // --- PROMĚNNÉ PRO PLYNULOU KAMERU ---
    private double currentCamX = 0;
    private double currentCamY = 0;
    private double currentZoom = 1.0;
    private final double SMOOTHING = 0.05; // Rychlost plynulosti (0.01 až 0.1)

    public MapLayoutPanel(GameMap gameMap, Player player1, Player player2, ResourcesForMap resources) {
        this.gameMap = gameMap;
        this.player1 = player1;
        this.player2 = player2;
        this.resources = resources;

        // Inicializace kamery na střed mezi hráče
        this.currentCamX = (player1.getX() + player2.getX()) / 2.0;
        this.currentCamY = (player1.getY() + player2.getY()) / 2.0;

        this.setLayout(null);
        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

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

        double requiredWidthPx = distWorldX * scaleFactor + 200;
        double requiredHeightPx = distWorldY * scaleFactor + 200;

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

        repaint();
    }

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
    }
}

