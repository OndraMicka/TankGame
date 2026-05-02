package map;

import entities.Player;

import java.util.ArrayList;

public class AllMaps {
    private ArrayList<GameMap> maps;

    public AllMaps() {
        maps = new ArrayList<>();
        maps.add(new GameMap("TestMap", "res/maps/mapTestCollisionGrid.png", "res/maps/mapTestCollisionGrid.png",new Player(10, 10), new Player(6.5, 1.5)));
        maps.add(new GameMap("GeminiMap", "res/maps/map1.png", "res/maps/map1CollisionGrid.png",new Player(10, 10), new Player(5, 5)));

        //TODO: load maps from json or something, add more maps
    }

    public GameMap getMap(String name) {
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).getName().equals(name)) {
                return maps.get(i);
            }
        }
        return null;
    }

    public String[] getArrayOfNames() {
        String[] names = new String[maps.size()];
        for (int i = 0; i < maps.size(); i++) {
            names[i] = maps.get(i).getName();
        }
        return names;
    }
}
