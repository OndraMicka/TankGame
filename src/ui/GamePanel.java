package ui;

import core.*;
import entities.Player;
import map.GameMap;
import settings.ConfigManager;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * The game panel that shows the actual game.
 * When created, game loop starts.
 * Displays the map, players, bullets, and health info.
 */
public class GamePanel extends JPanel {
    /** The main panel for switching screens. */
    private JPanel mainPanel;
    /** The game map. */
    private GameMap gameMap;
    /** The game thread running the game loop. */
    private GameThread thread;

    /** Info string for player 1 to show health. */
    private String player1Info;
    /** Info string for player 2 to show health. */
    private String player2Info;

    /** Label showing player 1 health. */
    private JLabel player1Health;
    /** Label showing player 2 health. */
    private JLabel player2Health;


    /**
     * Creates the game panel and starts the game.
     * @param mainPanel the main panel for switching screens
     * @param gameMap the map to play on, picked from beforeGameSettingsPanel
     */
    public GamePanel(JPanel mainPanel, GameMap gameMap) {
        this.mainPanel = mainPanel;
        this.gameMap = gameMap;
        thread = new GameThread(gameMap, this,60);
        thread.start();
        this.setLayout(new BorderLayout());
        this.add(thread.getMapLayoutPanel(), BorderLayout.CENTER);

        this.add(createHealthPanel(), BorderLayout.SOUTH);

        this.add(createTopPanel(), BorderLayout.NORTH);

        this.setFocusable(true);
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    /**
     * Creates the health panel showing both players' health.
     * @return the health panel
     */
    private JPanel createHealthPanel() {
        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        healthPanel.setBackground(new Color(50, 50, 50));

        player1Health = new JLabel();
        player1Health.setForeground(Color.RED);
        player1Health.setFont(new Font("Arial", Font.BOLD, 16));

        player2Health = new JLabel();
        player2Health.setForeground(Color.BLUE);
        player2Health.setFont(new Font("Arial", Font.BOLD, 16));
        
        healthPanel.add(player1Health);
        healthPanel.add(player2Health);
        
        return healthPanel;
    }
    
    /**
     * Creates the top panel with the end game button.
     * @return the top panel
     */
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(50, 50, 50));
        
        JButton endGameButton = JButtonFactory.createSettingsButton("End Game",e -> endGame());
        endGameButton.setFocusable(false);
        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        rightPanel.setBackground(new Color(50, 50, 50));
        rightPanel.add(endGameButton);
        
        topPanel.add(rightPanel, BorderLayout.EAST);
        
        return topPanel;
    }

    /**
     * Stops the game and goes back to the menu.
     */
    private void endGame(){
        thread.stopGame();

        CardLayout cl = (CardLayout) mainPanel.getLayout();
        mainPanel.remove(this);
        cl.show(mainPanel, "Menu");

    }

    /**
     * Updates the health display.
     */
    @Override
    public void paint(Graphics g) {
        //TODO add health bar
        super.paint(g);
        Settings.PlayerSettings player1 = ConfigManager.getSettings().getPlayer1();
        Settings.PlayerSettings player2 = ConfigManager.getSettings().getPlayer2();
        player1Info = player1.getPlayerName() + ": " + gameMap.getPlayer1().getHealth();
        player2Info = player2.getPlayerName() + ": " + gameMap.getPlayer2().getHealth();
        player1Health.setText(player1Info);
        player2Health.setText(player2Info);

    }
}
