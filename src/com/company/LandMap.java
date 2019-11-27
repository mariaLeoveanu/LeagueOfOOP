package com.company;

import java.util.ArrayList;

public class LandMap {
    private static LandMap firstInstance = null;
    public char[][] landMap;
    private LandMap(ArrayList<String> map){
        landMap = new char[map.size()][map.get(0).length()];
        for(int i = 0; i < map.size(); i++){
            landMap[i] = map.get(i).toCharArray();
        }
    }
    public static LandMap getInstance(ArrayList<String> map){
        if(firstInstance == null){
            firstInstance = new LandMap(map);
        }
        return firstInstance;
    }
}
