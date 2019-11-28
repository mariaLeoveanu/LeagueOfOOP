package com.company;

import heroes.Hero;
import heroes.Wizard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        ReadGameData readGameData = new ReadGameData("test");
        readGameData.readData();
        ArrayList<Hero> heroes = readGameData.heroes;
        ArrayList<WizardOpponentPair> wizards = new ArrayList<>();
        for(int i = 0; i < readGameData.rounds; i++){
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
                    if(!readGameData.heroes.get(j).getClass().equals(Wizard.class)){
                        readGameData.heroes.get(j).attack(readGameData.heroes.get(opponent), readGameData.map.landMap);
                    } else {
                        wizards.add(new WizardOpponentPair(heroes.get(j), heroes.get(opponent)));
                    }
                }
            }
            for (int j = 0; j < wizards.size(); j++){
                wizards.get(j).wizard.attack(wizards.get(j).opponent, readGameData.map.landMap);
            }

            for(int j = 0; j < readGameData.heroes.size(); j++){
                readGameData.heroes.get(j).wasAttackedThisRound = false;
            }
            wizards.clear();
        }
        for(int j = 0; j < heroes.size(); j++){
            System.out.println(heroes.get(j).name + " " + heroes.get(j).level + " "
             + heroes.get(j).xp + " " + heroes.get(j).hp + " " + heroes.get(j).x +
                    " " + heroes.get(j).y);
        }


    }
}
