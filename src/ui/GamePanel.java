package ui;

import core.*;
import entities.Player;
import map.GameMap;
import settings.ConfigManager;
import settings.Settings;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JPanel mainPanel;
    private GameMap gameMap;
    private GameThread thread;

    private String player1Info;
    private String player2Info;

    private JLabel player1Health;
    private JLabel player2Health;


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
        SwingUtilities.invokeLater(() -> this.requestFocusInWindow());
    }

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

    private void endGame(){
        thread.stopGame();

        CardLayout cl = (CardLayout) mainPanel.getLayout();
        mainPanel.remove(this);
        cl.show(mainPanel, "Menu");

    }

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
