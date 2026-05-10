package settings;


import types.MyReferenceString;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds all game settings for both players.
 * Stores key bindings and other player specific configuration.
 */
public class Settings {
    /** Settings for player 1. */
    private PlayerSettings player1 = new PlayerSettings();
    /** Settings for player 2. */
    private PlayerSettings player2 = new PlayerSettings();

    public PlayerSettings getPlayer1() {
        return player1;
    }

    public PlayerSettings getPlayer2() {
        return player2;
    }

    /**
     * Inner class holding settings for a single player.
     * Includes key bindings for all actions.
     */
    public class PlayerSettings {
        /** The player's name. */
        private MyReferenceString playerName;

        /** Key code for moving forward. */
        private AtomicInteger forward;
        /** Key code for moving backward. */
        private AtomicInteger backward;
        /** Key code for firing a rocket. */
        private AtomicInteger rocket;
        /** Key code for firing a bullet. */
        private AtomicInteger bullet;
        /** Key code for rotating turret left. */
        private AtomicInteger rotateTurretLeft;
        /** Key code for rotating turret right. */
        private AtomicInteger rotateTurretRight;
        /** Key code for rotating tank left. */
        private AtomicInteger rotateTankLeft;
        /** Key code for rotating tank right. */
        private AtomicInteger rotateTankRight;

        /**
         * Constructor required for gson.
         */
        public PlayerSettings() {
        }


        /**
         * Getters and setters for all settings fields.
         */
        public AtomicInteger getForward() {
            return forward;
        }

        public AtomicInteger getBackward() {
            return backward;
        }

        public AtomicInteger getRocket() {
            return rocket;
        }

        public AtomicInteger getBullet() {
            return bullet;
        }

        public AtomicInteger getRotateTurretLeft() {
            return rotateTurretLeft;
        }

        public AtomicInteger getRotateTurretRight() {
            return rotateTurretRight;
        }

        public AtomicInteger getRotateTankLeft() {
            return rotateTankLeft;
        }

        public AtomicInteger getRotateTankRight() {
            return rotateTankRight;
        }

        public MyReferenceString getPlayerName() {
            return playerName;
        }

        public void setPlayerName(MyReferenceString playerName) {
            this.playerName = playerName;
        }


        public void setForward(AtomicInteger forward) {
            this.forward = forward;
        }

        public void setBackward(AtomicInteger backward) {
            this.backward = backward;
        }

        public void setRocket(AtomicInteger rocket) {
            this.rocket = rocket;
        }

        public void setBullet(AtomicInteger bullet) {
            this.bullet = bullet;
        }

        public void setRotateTurretLeft(AtomicInteger rotateTurretLeft) {
            this.rotateTurretLeft = rotateTurretLeft;
        }

        public void setRotateTurretRight(AtomicInteger rotateTurretRight) {
            this.rotateTurretRight = rotateTurretRight;
        }

        public void setRotateTankLeft(AtomicInteger rotateTankLeft) {
            this.rotateTankLeft = rotateTankLeft;
        }

        public void setRotateTankRight(AtomicInteger rotateTankRight) {
            this.rotateTankRight = rotateTankRight;
        }
    }


}
