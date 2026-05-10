package blocksOnMap;

/**
 * Abstract class representing a block on the game map.
 * Map of blocks is not visible for player.
 * Blocks are used for collision detection, player or bullet cannot pass wall
 */
public abstract class Block {

    /**
     * Index of block on map.
     */
    private int x;
    private int y;


    /**
     * Whether the block is passable (empty space) or not (wall).
     * Used for collision detection.
     */
    private boolean passable;


    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }
}
