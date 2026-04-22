package maps;

import blocksOnMap.Block;
import blocksOnMap.EmptySpace;
import blocksOnMap.Wall;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameMap {
    private final int width, height;
    private final Block[][] mapArray;

    public GameMap(int width, int height, String imageResPath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imageResPath));

            if (width % 2 == 1 && height % 2 == 1) {
                this.width = image.getWidth();
                this.height = image.getHeight();
                this.mapArray = new Block[width][height];

                createMap(image);
            } else {
                throw new IllegalArgumentException("Height and width must be an odd number.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createMap(BufferedImage image) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = image.getRGB(x, y);
                switch (pixel) {
                    case -16777216:
                        mapArray[x][y] = new Wall(x, y);
                    case -1:
                        mapArray[x][y] = new EmptySpace(x, y);
                }
            }
        }
    }

    private void add(Block block) {
        int x = block.getX();
        int y = block.getY();

        if (block instanceof Wall) {
            if (x % 2 == 0 && y % 2 == 0) {
                mapArray[x][y] = block;
            } else {
                throw new IllegalArgumentException("Walls must be placed at even coordinates.");
            }
        } else {
            if (x % 2 == 1 && y % 2 == 1) {
                mapArray[x][y] = block;
            } else {
                throw new IllegalArgumentException("Blocks that are not wall, must be placed at odd coordinates.");
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Block[][] getMapArray() {
        return mapArray;
    }
}

