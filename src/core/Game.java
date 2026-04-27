package core;

import ui.MyFrame;

public class Game {
    private Player player1, player2;
    private GameMap currentMap;


    public Game(Player player1, Player player2, GameMap currentMap) {
        player1 = player1;
        player2 = player2;
        this.currentMap = currentMap;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameMap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(GameMap currentMap) {
        this.currentMap = currentMap;
    }
}
