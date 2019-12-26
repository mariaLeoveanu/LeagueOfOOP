package main;

import fileio.implementations.FileWriter;
import heroes.Hero;
import heroes.Wizard;

import java.io.IOException;
import java.util.ArrayList;

final class GameProcess {
    private ReadGameData readGameData;

    GameProcess(final ReadGameData r) {
        readGameData = r;
    }

    void startGame(FileWriter printData) throws IOException {

        ArrayList<Hero> heroes = readGameData.getHeroes();

        //wizard list used to store all wizards that have to attack their opponents
        //because of deflect ability, they have to attack last
        ArrayList<WizardOpponentPair> wizards = new ArrayList<>();

        for (int i = 0; i < readGameData.getRounds(); i++) {

            //all players check if they have any overtime damage
            printData.writeWord("~~ Round " + (i + 1) + " ~~");
            printData.writeNewLine();
            for (int j = 0; j < readGameData.getPlayers(); j++) {
                heroes.get(j).checkOtDmg();
                heroes.get(j).chooseStrategy();
            }

            for (int j = 0; j < readGameData.getPlayers(); j++) {
                heroes.get(j).move(readGameData.getMovesMat()[i][j]);
            }
            int opponent;
            for (int j = 0; j < readGameData.getPlayers(); j++) {
                opponent = heroes.get(j).checkForOpponents(heroes, j);
                if (opponent >= 0) {
                    if (!heroes.get(j).getClass().equals(Wizard.class)) {
                        heroes.get(j).attack(heroes.get(opponent),
                                readGameData.getMap().getLandMap());
                        heroes.get(j).checkIfOpponentKilled(heroes.get(opponent), printData);
                    } else {
                        wizards.add(new WizardOpponentPair(heroes.get(j), heroes.get(opponent)));
                    }
                }
            }
            for (WizardOpponentPair wizard : wizards) {
                wizard.getWizard().attack(wizard.getOpponent(),
                        readGameData.getMap().getLandMap());
                wizard.getWizard().checkIfOpponentKilled(wizard.getOpponent(), printData);
            }

            //reset all attackedThisRound flags at the end of the round

            for (int j = 0; j < readGameData.getHeroes().size(); j++) {
                heroes.get(j).setWasAttackedThisRound(false);
                heroes.get(j).tryLevelUp(printData);
            }


            wizards.clear();

            // angels spawn

            for (int j = 0; j < readGameData.angels.get(i).size(); j++) {
                readGameData.angels.get(i).get(j).spawn(printData);
                ArrayList<Integer> neighbours = new ArrayList<>();
                neighbours = readGameData.angels.get(i).get(j).checkForHeroes(heroes);
                if (neighbours != null && neighbours.size() > 0) {
                    for (Integer neighbour : neighbours) {
                        heroes.get(neighbour).accept(readGameData.angels.get(i).get(j), printData);
                    }
                }
            }
            printData.writeNewLine();
        }
    }
}
