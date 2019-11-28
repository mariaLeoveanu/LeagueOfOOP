package com.company;

import heroes.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        ReadGameData readGameData = new ReadGameData("test");
        readGameData.readData();
        ArrayList<Hero> heroes = readGameData.heroes;
        for(int i = 0; i < readGameData.rounds; i++){
            System.out.println("Round " + i);
            for (int j = 0; j < readGameData.players; j++){
                readGameData.heroes.get(j).checkOtDmg();
            }
            for (int j = 0; j < readGameData.players; j++){
                readGameData.heroes.get(j).move(readGameData.movesMat[i][j]);
            }
            int opponent;
            for (int j = 0; j < readGameData.players; j++){
                opponent = readGameData.heroes.get(j).checkForOpponents(readGameData.heroes, j);
                if(opponent >= 0){
                    readGameData.heroes.get(j).attack(readGameData.heroes.get(opponent), readGameData.map.landMap);
                }
            }
            for(int j = 0; j < readGameData.heroes.size(); j++){
                //System.out.println(readGameData.heroes.get(j).getClass() + " " + readGameData.heroes.get(j).hp);
            }
            for(int j = 0; j < readGameData.heroes.size(); j++){
                readGameData.heroes.get(j).wasAttackedThisRound = false;
            }
        }
        for(int j = 0; j < heroes.size(); j++){
            System.out.println(heroes.get(j).name + " " + heroes.get(j).level + " "
             + heroes.get(j).xp + " " + heroes.get(j).hp + " " + heroes.get(j).x +
                    " " + heroes.get(j).y);
        }

    }
}
