package core;

import blocksOnMap.Wall;
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

    // --- PROMĚNNÉ PRO PLYNULOU KAMERU ---
    private double currentCamX = 0;
    private double currentCamY = 0;
    private double currentZoom = 1.0;
    private final double SMOOTHING = 0.05; // Rychlost plynulosti (0.01 až 0.1)

    public MapLayoutPanel(GameMap gameMap, Player player1, Player player2) {
        this.gameMap = gameMap;
        this.player1 = player1;
        this.player2 = player2;

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

        // Zapnutí vyhlazování pro hezčí pohyb
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // 1. VÝPOČET CÍLOVÝCH HODNOT (Kam kamera chce jít)
        double targetX = (player1.getX() + player2.getX()) / 2.0 + 0.5;
        double targetY = (player1.getY() + player2.getY()) / 2.0 + 0.5;

        double distWorldX = Math.abs(player1.getX() - player2.getX()) + 1.5;
        double distWorldY = Math.abs(player1.getY() - player2.getY()) + 1.5;

        double requiredWidthPx = distWorldX * scaleFactor + 200; // 100px okraj z každé strany
        double requiredHeightPx = distWorldY * scaleFactor + 200;

        double targetZoom = Math.min((double) panelWidth / requiredWidthPx, (double) panelHeight / requiredHeightPx);

        // Omezení, aby se zoom nezbláznil
        if (targetZoom > 2.0) targetZoom = 2.0;
        if (targetZoom < 0.2) targetZoom = 0.2;

        // 2. LERP - PLYNULÝ PŘECHOD
        // Aktuální hodnota se přiblíží k cílové o zlomek vzdálenosti
        currentCamX += (targetX - currentCamX) * SMOOTHING;
        currentCamY += (targetY - currentCamY) * SMOOTHING;
        currentZoom += (targetZoom - currentZoom) * SMOOTHING;

        // 3. APLIKACE TRANSFORMACÍ
        // Nejdřív posuneme střed kreslení do středu okna
        g2d.translate(panelWidth / 2.0, panelHeight / 2.0);
        // Poté aplikujeme zoom
        g2d.scale(currentZoom, currentZoom);
        // Nakonec posuneme mapu tak, aby střed kamery byl uprostřed
        g2d.translate(-currentCamX * scaleFactor, -currentCamY * scaleFactor);

        // 4. VYKRESLENÍ MAPY
        for (int y = 0; y < gameMap.getHeight(); y++) {
            for (int x = 0; x < gameMap.getWidth(); x++) {
                if (gameMap.getMapArray()[x][y] instanceof Wall) {
                    g2d.setColor(Color.black);
                    g2d.fillRect(x * scaleFactor, y * scaleFactor, scaleFactor, scaleFactor);
                }
            }
        }

        // 5. VYKRESLENÍ HRÁČŮ
        g2d.setColor(Color.blue);
        g2d.fillRect((int)(player1.getX() * scaleFactor), (int)(player1.getY() * scaleFactor), scaleFactor, scaleFactor);

        g2d.setColor(Color.red);
        g2d.fillRect((int)(player2.getX() * scaleFactor), (int)(player2.getY() * scaleFactor), scaleFactor, scaleFactor);

        // Způsobí, že se paintComponent volá znovu a znovu pro plynulou animaci
        repaint();
    }
}

