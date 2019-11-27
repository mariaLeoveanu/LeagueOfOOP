package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        ReadGameData readGameData = new ReadGameData("test");
        readGameData.readData();
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
                    readGameData.heroes.get(opponent).attack(readGameData.heroes.get(j), readGameData.map.landMap);
                    //readGameData.heroes.get(j).attack(readGameData.heroes.get(opponent), readGameData.map.landMap);
                }
            }
            System.out.println(readGameData.heroes.get(0).hp);
            System.out.println(readGameData.heroes.get(1).hp);
        }

    }
}
