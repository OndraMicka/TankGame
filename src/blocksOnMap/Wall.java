package blocksOnMap;

/**
 * Represents a wall on the game map that is not passable.
 * Tanks cannot move through walls, used for collision detection.
 */
public class Wall extends Block{
    public Wall(int x, int y) {
        super(x, y);
        setPassable(false);
    }
}
