package core;


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
        private AtomicInteger moveForwardKey;
        private AtomicInteger moveBackKey;
        private AtomicInteger turnLeftKey;
        private AtomicInteger turnRightKey;
        private AtomicInteger fireKey;
        private MyReferenceString playerName;

        public PlayerSettings() {
        }

        public AtomicInteger getMoveForwardKey() {
            return moveForwardKey;
        }

        public void setMoveForwardKey(AtomicInteger moveForwardKey) {
            this.moveForwardKey = moveForwardKey;
        }

        public AtomicInteger getMoveBackKey() {
            return moveBackKey;
        }

        public void setMoveBackKey(AtomicInteger moveBackKey) {
            this.moveBackKey = moveBackKey;
        }

        public AtomicInteger getTurnLeftKey() {
            return turnLeftKey;
        }

        public void setTurnLeftKey(AtomicInteger turnLeftKey) {
            this.turnLeftKey = turnLeftKey;
        }

        public AtomicInteger getTurnRightKey() {
            return turnRightKey;
        }

        public void setTurnRightKey(AtomicInteger turnRightKey) {
            this.turnRightKey = turnRightKey;
        }

        public AtomicInteger getFireKey() {
            return fireKey;
        }

        public void setFireKey(AtomicInteger fireKey) {
            this.fireKey = fireKey;
        }

        public MyReferenceString getPlayerName() {
            return playerName;
        }

        public void setPlayerName(MyReferenceString playerName) {
            this.playerName = playerName;
        }
    }


}
