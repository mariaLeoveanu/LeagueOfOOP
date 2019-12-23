package main;

import fileio.implementations.FileWriter;
import heroes.Hero;


import java.io.IOException;
import java.util.ArrayList;

class PrintGameData {

    void printData(final ArrayList<Hero> heroes, final FileWriter printData) throws IOException {
        for (Hero hero : heroes) {
            if (hero.getHp() == 0) {
                printData.writeCharacter(hero.getName());
                printData.writeWord(" dead");
            } else {
                printData.writeCharacter(hero.getName());
                printData.writeWord(" ");
                printData.writeInt(hero.getLevel());
                printData.writeWord(" ");
                printData.writeInt(hero.getXp());
                printData.writeWord(" ");
                printData.writeInt(hero.getHp());
                printData.writeWord(" ");
                printData.writeInt(hero.getX());
                printData.writeWord(" ");
                printData.writeInt(hero.getY());
            }
            printData.writeNewLine();
        }
        printData.close();
    }
}
