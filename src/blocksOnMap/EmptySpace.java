package blocksOnMap;

/**
 * Represents an empty space on the game map that is passable.
 * Tanks can move through empty spaces without collision.
 */
public class EmptySpace extends Block{
    public EmptySpace(int x, int y) {
        super(x, y);
        setPassable(true);
    }
}
