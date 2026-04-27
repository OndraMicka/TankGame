package core;

import java.util.ArrayList;

public class AllMaps {
    private ArrayList<GameMap> maps;
    public AllMaps() {
        maps = new ArrayList<>();
        maps.add(new GameMap("TestMap","res/maps/mapTest.png"));

    }

    public GameMap getMap(String name){
        for (int i = 0; i < maps.size(); i++) {
            if(maps.get(i).getName().equals(name)){
                return maps.get(i);
            }
        }return null;
    }
    public String[] getArrayOfNames(){
        String[] names = new String[maps.size()];
        for (int i = 0; i < maps.size(); i++) {
            names[i] = maps.get(i).getName();
        }
        return names;
    }
}
