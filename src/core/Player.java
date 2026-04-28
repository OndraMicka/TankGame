package core;

public class Player {
    private int health;
    private int maxHealth;

    private int maxSpeed;
    private int speed;

    private double rotation;
    private double x;
    private double y;

    public Player(double x,double y) {
        this.y = y;
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
}
