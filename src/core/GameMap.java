package core;

import blocksOnMap.Block;
import blocksOnMap.EmptySpace;
import blocksOnMap.Wall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameMap {
    private int width, height;
    private final Block[][] mapArray;

    public GameMap(String filePath) {
        BufferedImage img;
        try {
            img = ImageIO.read(new File(filePath));
            setHeight(img.getHeight());
            setWidth(img.getWidth());
            mapArray = new Block[getHeight()][getWidth()];
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

}

