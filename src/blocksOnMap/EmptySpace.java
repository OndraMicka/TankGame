package blocksOnMap;

public class EmptySpace extends Block{
    public EmptySpace(int x, int y) {
        super(x, y);
        setPassable(true);
    }
}
