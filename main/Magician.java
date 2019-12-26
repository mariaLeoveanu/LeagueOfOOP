package main;

import angels.Visitor;
import fileio.implementations.FileWriter;
import heroes.Hero;

import java.io.IOException;

public class Magician {

    public Magician() throws IOException {
    }


    public void updateAction(Visitor angel, Hero hero , int idHero, FileWriter fileWriter) throws IOException {
       fileWriter.writeWord(angel.name + " " + angel.actionType + " " + hero.type + " " + idHero);
       fileWriter.writeNewLine();
    }

    public void updateSpawn(Visitor angel, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Angel " + angel.name + " was spawned at " + angel.x + " " + angel.y);
        fileWriter.writeNewLine();
    }

    public void updateHeroKilled(Hero killer, Hero killed, int idKiller, int idKilled, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player " + killed.type + " " + idKilled + " was killed by " + killer.type + " " + idKiller);
        fileWriter.writeNewLine();
    }

    public void updateAngelKilled(Hero killed, int idKilled, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player " + killed.type + " " + idKilled+ " was killed by an angel");
        fileWriter.writeNewLine();
    }
    public void updateLevelUp(Hero hero, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord(hero.type + " " + hero.id + " reached level " + hero.getLevel());
        fileWriter.writeNewLine();
    }

    public void updateRespawn(Hero hero, FileWriter fileWriter) throws IOException {
        fileWriter.writeWord("Player " + hero.type + " " + hero.id + " was brought to life by an angel");
        fileWriter.writeNewLine();
    }
}
