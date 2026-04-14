package core;


public class Settings {
    private PlayerSettings player1 = new PlayerSettings();
    private PlayerSettings player2 = new PlayerSettings();

    public PlayerSettings getPlayer1() {
        return player1;
    }

    public PlayerSettings getPlayer2() {
        return player2;
    }

    public class PlayerSettings {
        private int moveForwardKey;
        private int moveBackKey;
        private int turnLeftKey;
        private int turnRightKey;
        private int fireKey;
        private String playerName;

        public PlayerSettings() {
        }

        public int getMoveForwardKey() {
            return moveForwardKey;
        }

        public void setMoveForwardKey(int moveForwardKey) {
            this.moveForwardKey = moveForwardKey;
        }

        public int getMoveBackKey() {
            return moveBackKey;
        }

        public void setMoveBackKey(int moveBackKey) {
            this.moveBackKey = moveBackKey;
        }

        public int getTurnLeftKey() {
            return turnLeftKey;
        }

        public void setTurnLeftKey(int turnLeftKey) {
            this.turnLeftKey = turnLeftKey;
        }

        public int getTurnRightKey() {
            return turnRightKey;
        }

        public void setTurnRightKey(int turnRightKey) {
            this.turnRightKey = turnRightKey;
        }

        public int getFireKey() {
            return fireKey;
        }

        public void setFireKey(int fireKey) {this.fireKey = fireKey;}

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }
    }



}
