package settings;


import types.MyReferenceString;

import java.util.concurrent.atomic.AtomicInteger;

public class Settings {
    //TODO: add settings for player to chose map, int index
    private PlayerSettings player1 = new PlayerSettings();
    private PlayerSettings player2 = new PlayerSettings();

    public PlayerSettings getPlayer1() {
        return player1;
    }

    public PlayerSettings getPlayer2() {
        return player2;
    }

    public class PlayerSettings {
        private MyReferenceString playerName;

        private AtomicInteger forward, backward;
        private AtomicInteger rocket,bullet;
        private AtomicInteger rotateTurretLeft, rotateTurretRight;
        private AtomicInteger rotateTankLeft, rotateTankRight;

        public PlayerSettings() {
        }


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
