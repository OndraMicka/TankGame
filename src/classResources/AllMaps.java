package classResources;

import entities.Player;
import map.GameMap;

import java.util.ArrayList;

/**
 * This class holds all the game maps.
 * It has a list of maps and lets you get them by name or get a list of names.
 */
public class AllMaps {
    private ArrayList<GameMap> maps;

    /**
     * Creates the list of maps.
     * TODO: maybe load from json or add more maps later.
     */
    public AllMaps() {
        maps = new ArrayList<>();
        maps.add(new GameMap("TestMap", "res/maps/mapTestCollisionGrid.png", "res/maps/mapTestCollisionGrid.png",new Player(10, 10), new Player(6.5, 1.5)));
        maps.add(new GameMap("GeminiMap", "res/maps/map1.png", "res/maps/map1CollisionGrid.png",new Player(31, 16), new Player(5, 5)));

    }

    /**
     * Gets a map by its name.
     * @param name the name of the map
     * @return the GameMap if found, or null if not
     */
    public GameMap getMap(String name) {
        for (int i = 0; i < maps.size(); i++) {
            if (maps.get(i).getName().equals(name)) {
                return maps.get(i);
            }
        }
        return null;
    }

    /**
     * Gets an array of all map names.
     * Used for the menu to show the list of maps to pick.
     * @return array of strings with the names
     */
    public String[] getArrayOfNames() {
        String[] names = new String[maps.size()];
        for (int i = 0; i < maps.size(); i++) {
            names[i] = maps.get(i).getName();
        }
        return names;
    }
}
