package main;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.Wizard;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        ReadGameData readGameData = new ReadGameData("test");
        FileWriter printData = new FileWriter("output");
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
                        readGameData.heroes.get(j).checkIfOpponentKilled(readGameData.heroes.get(opponent));
                    } else {
                        wizards.add(new WizardOpponentPair(heroes.get(j), heroes.get(opponent)));
                    }
                }
            }
            for (int j = 0; j < wizards.size(); j++){
                wizards.get(j).wizard.attack(wizards.get(j).opponent, readGameData.map.landMap);
                wizards.get(j).wizard.checkIfOpponentKilled(wizards.get(j).opponent);
            }


            for(int j = 0; j < readGameData.heroes.size(); j++){
                readGameData.heroes.get(j).wasAttackedThisRound = false;
                readGameData.heroes.get(j).tryLevelUp();
            }
            wizards.clear();

        }

        for(int j = 0; j < heroes.size(); j++){
            if (heroes.get(j).hp == 0){
                printData.writeCharacter(heroes.get(j).name);
                printData.writeWord(" dead");
                System.out.println(heroes.get(j).name + " dead");
            }else {
                printData.writeCharacter(heroes.get(j).name);
                printData.writeWord(" ");
                printData.writeInt(heroes.get(j).level);
                printData.writeWord(" ");
                printData.writeInt(heroes.get(j).xp);
                printData.writeWord(" ");
                printData.writeInt(heroes.get(j).hp);
                printData.writeWord(" ");
                printData.writeInt(heroes.get(j).x);
                printData.writeWord(" ");
                printData.writeInt(heroes.get(j).y);
                System.out.println(heroes.get(j).name + " " + heroes.get(j).level + " "
                        + heroes.get(j).xp + " " + heroes.get(j).hp + " " + heroes.get(j).x +
                        " " + heroes.get(j).y);
            }
            printData.writeNewLine();
        }
        printData.close();


    }
}
