package core;

import java.util.ArrayList;

public class AllMaps {
    private ArrayList<GameMap> maps;
    public AllMaps() {
        maps = new ArrayList<>();
        maps.add(new GameMap("res/maps/mapTest.png"));
    }

    public GameMap getMap(int index){
        return maps.get(index);
    }
}
