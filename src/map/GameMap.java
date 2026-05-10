package map;

import blocksOnMap.Block;
import blocksOnMap.EmptySpace;
import blocksOnMap.Wall;
import entities.Bullet;
import entities.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents the game map.
 * Stores the map of blocks, used for collision detection
 * And the visual image of the map.
 * TODO load map from json(Tiled map editor) instead of using an image for the collision grid and for visuals, maybe add destructible walls and other block types.
 */
public class GameMap {
    private int width, height;

    /**
     * Array of the collision grid.
     */
    private final Block[][] mapArray;

    /** Name of the map. */
    private final String name;

    /** List of bullets currently on the map. */
    private final CopyOnWriteArrayList<Bullet> bullets;

    /** The visual image of the map. */
    private Image image;

   private Player player1;
   private Player player2;

    /**
     * Creates a new game map.
     * Loads the map image and collision grid from files.
     * @param name the name of the map
     * @param mapImage path to the visual map image
     * @param filePathCollisionGrid path to the collision grid image
     * @param player1 first player
     * @param player2 second player
     */
    public GameMap(String name,String mapImage,String filePathCollisionGrid, Player player1, Player player2) {
        BufferedImage img;
        bullets = new CopyOnWriteArrayList<>();
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

    /**
     * Adds or updates a block at a specific position.
     * TODO: maybe make it so that you can destroy walls with rockets
     * @param block the block to add
     */
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
    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }
    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }
}

