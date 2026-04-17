package core;

import blocksOnMap.Block;
import blocksOnMap.Wall;

public class GameMap {
    private int width, height;
    private final Block[][] mapArray;

    public GameMap(int width, int height) {
        this.mapArray = new Block[width][height];
    }

    public void add(Block block) {
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

    public void setWidth(int width) {
        if (width % 2 == 1) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be an odd number.");
        }
    }

    public void setHeight(int height) {
        if (height % 2 == 1) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be an odd number.");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

