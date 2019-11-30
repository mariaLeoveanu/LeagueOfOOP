package main;

import java.util.ArrayList;

public final class LandMap {
    // singleton class for the map of the game
    private static LandMap firstInstance = null;
    private char[][] landMap;

    private LandMap(final ArrayList<String> map) {
        setLandMap(new char[map.size()][map.get(0).length()]);
        for (int i = 0; i < map.size(); i++) {
            getLandMap()[i] = map.get(i).toCharArray();
        }
    }

    public static LandMap getInstance(final ArrayList<String> map) {
        if (firstInstance == null) {
            firstInstance = new LandMap(map);
        }
        return firstInstance;
    }

    public char[][] getLandMap() {
        return landMap;
    }

    public void setLandMap(final char[][] landMap) {
        this.landMap = landMap;
    }
}
