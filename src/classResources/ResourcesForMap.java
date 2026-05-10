package classResources;

import java.awt.*;

/**
 * This class holds all images of the game.
 * Like tank bodies, turrets, bullets, etc.
 */
public class ResourcesForMap {
    //center of image must be place for turret.
    private Image player1Body;
    private Image player2Body;

    //center of image must be center of rotation for turret
    private Image player1Turret;
    private Image player2Turret;

    private Image map;

    private Image bullet;
    private Image rocket;


    public Image getPlayer1Body() {
        return player1Body;
    }

    public void setPlayer1Body(Image player1Body) {
        this.player1Body = player1Body;
    }

    public Image getPlayer2Body() {
        return player2Body;
    }

    public void setPlayer2Body(Image player2Body) {
        this.player2Body = player2Body;
    }

    public Image getPlayer1Turret() {
        return player1Turret;
    }

    public void setPlayer1Turret(Image player1Turret) {
        this.player1Turret = player1Turret;
    }

    public Image getPlayer2Turret() {
        return player2Turret;
    }

    public void setPlayer2Turret(Image player2Turret) {
        this.player2Turret = player2Turret;
    }

    public Image getMap() {
        return map;
    }

    public void setMap(Image map) {
        this.map = map;
    }

    public Image getBullet() {
        return bullet;
    }

    public void setBullet(Image bullet) {
        this.bullet = bullet;
    }

    public Image getRocket() {
        return rocket;
    }

    public void setRocket(Image rocket) {
        this.rocket = rocket;
    }
}
