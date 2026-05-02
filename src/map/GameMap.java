package map;

import blocksOnMap.Block;
import blocksOnMap.EmptySpace;
import blocksOnMap.Wall;
import entities.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameMap {
    private int width, height;
    private final Block[][] mapArray;
    private final String name;

    //private final ArrayList<Bullet> bullets;

    private Image image;

   private Player player1;
   private Player player2;

    public GameMap(String name,String mapImage,String filePathCollisionGrid, Player player1, Player player2) {
        BufferedImage img;
        this.player1 = player1;
        this.player2 = player2;
        this.name = name;
        try {
            image = ImageIO.read(new File(mapImage));
            img = ImageIO.read(new File(filePathCollisionGrid));
            setHeight(img.getHeight());
            setWidth(img.getWidth());
            mapArray = new Block[getWidth()][getHeight()];
            for (int x = 0; x <img.getWidth() ; x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    if (img.getRGB(x, y) == Color.WHITE.getRGB()) {
                        mapArray[x][y] = new EmptySpace(x, y);
                    }else {
                        mapArray[x][y] = new Wall(x, y);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Block block) {
        int x = block.getX();
        int y = block.getY();
        mapArray[x][y] = block;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Block[][] getMapArray() {
        return mapArray;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Image getImage() {
        return image;
    }
}

