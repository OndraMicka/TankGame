package core;

import entities.Player;
import settings.ConfigManager;
import settings.Settings;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputManager extends KeyAdapter {
    private PlayerInput player1Input;
    private PlayerInput player2Input;

    public KeyInputManager() {
        this.player1Input = new PlayerInput();
        this.player2Input = new PlayerInput();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        Settings.PlayerSettings player1Settings = ConfigManager.getSettings().getPlayer1();
        Settings.PlayerSettings player2Settings = ConfigManager.getSettings().getPlayer2();
        
        // Player 1
        if (key == player1Settings.getForward().get()) player1Input.forward = true;
        if (key == player1Settings.getBackward().get()) player1Input.backward = true;
        if (key == player1Settings.getRotateTurretLeft().get()) player1Input.rotateTurretLeft = true;
        if (key == player1Settings.getRotateTurretRight().get()) player1Input.rotateTurretRight = true;
        if (key == player1Settings.getBullet().get()) player1Input.bullet = true;
        if (key == player1Settings.getRocket().get()) player1Input.rocket = true;
        if (key == player1Settings.getRotateTankLeft().get()) player1Input.rotateTankLeft = true;
        if (key == player1Settings.getRotateTankRight().get()) player1Input.rotateTankRight = true;
        
        // Player 2
        if (key == player2Settings.getForward().get()) player2Input.forward = true;
        if (key == player2Settings.getBackward().get()) player2Input.backward = true;
        if (key == player2Settings.getRotateTurretLeft().get()) player2Input.rotateTurretLeft = true;
        if (key == player2Settings.getRotateTurretRight().get()) player2Input.rotateTurretRight = true;
        if (key == player2Settings.getBullet().get()) player2Input.bullet = true;
        if (key == player2Settings.getRocket().get()) player2Input.rocket = true;
        if (key == player2Settings.getRotateTankLeft().get()) player2Input.rotateTankLeft = true;
        if (key == player2Settings.getRotateTankRight().get()) player2Input.rotateTankRight = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        Settings.PlayerSettings player1Settings = ConfigManager.getSettings().getPlayer1();
        Settings.PlayerSettings player2Settings = ConfigManager.getSettings().getPlayer2();
        
        // Player 1
        if (key == player1Settings.getForward().get()) player1Input.forward = false;
        if (key == player1Settings.getBackward().get()) player1Input.backward = false;
        if (key == player1Settings.getRotateTurretLeft().get()) player1Input.rotateTurretLeft = false;
        if (key == player1Settings.getRotateTurretRight().get()) player1Input.rotateTurretRight = false;
        if (key == player1Settings.getBullet().get()) player1Input.bullet = false;
        if (key == player1Settings.getRocket().get()) player1Input.rocket = false;
        if (key == player1Settings.getRotateTankLeft().get()) player1Input.rotateTankLeft = false;
        if (key == player1Settings.getRotateTankRight().get()) player1Input.rotateTankRight = false;
        
        // Player 2
        if (key == player2Settings.getForward().get()) player2Input.forward = false;
        if (key == player2Settings.getBackward().get()) player2Input.backward = false;
        if (key == player2Settings.getRotateTurretLeft().get()) player2Input.rotateTurretLeft = false;
        if (key == player2Settings.getRotateTurretRight().get()) player2Input.rotateTurretRight = false;
        if (key == player2Settings.getBullet().get()) player2Input.bullet = false;
        if (key == player2Settings.getRocket().get()) player2Input.rocket = false;
        if (key == player2Settings.getRotateTankLeft().get()) player2Input.rotateTankLeft = false;
        if (key == player2Settings.getRotateTankRight().get()) player2Input.rotateTankRight = false;
    }

    public class PlayerInput{
        private boolean forward, backward;
        private boolean rocket,bullet;
        private boolean rotateTurretLeft, rotateTurretRight;
        private boolean rotateTankLeft, rotateTankRight;


        public boolean isForward() {
            return forward;
        }

        public boolean isBackward() {
            return backward;
        }

        public boolean isRocket() {
            return rocket;
        }

        public boolean isBullet() {
            return bullet;
        }

        public boolean isRotateTurretLeft() {
            return rotateTurretLeft;
        }

        public boolean isRotateTurretRight() {
            return rotateTurretRight;
        }

        public boolean isRotateTankLeft() {
            return rotateTankLeft;
        }

        public boolean isRotateTankRight() {
            return rotateTankRight;
        }
    }

    public PlayerInput getPlayer1Input() {
        return player1Input;
    }

    public PlayerInput getPlayer2Input() {
        return player2Input;
    }
}
