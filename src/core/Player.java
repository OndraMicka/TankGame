package core;

public class Player {
    private int health;
    private int maxHealth;

    private int maxSpeed;
    private int speed;

    private double rotation;
    private double x;
    private double y;

    public Player(int x,int y) {
        this.y = y;
        this.x = x;
    }

}
