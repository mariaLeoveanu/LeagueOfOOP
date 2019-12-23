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

    public void updateSpawn(Visitor angel){
        System.out.println("Angel " + angel.name + " was spawned at " + angel.x + " " + angel.y);
    }

    public void updateHeroKilled(Hero killer, Hero killed, int idKiller, int idKilled){
        System.out.println("Player " + killed.type + " " + idKilled + " was killed by " + killer.type + " " + idKiller);
    }

    public void updateAngelKilled(Hero killed, int idKilled){
        System.out.println("Player " + killed.type + " " + killed.id + " was killed by an angel");
    }
    public void updateLevelUp(Hero hero){
        System.out.println(hero.type + " " + hero.id + " reached level " + hero.getLevel());
    }

    public void updateRespawn(Hero hero){
        System.out.println("Player " + hero.type + " " + hero.id + " was brought back to life by an angel");
    }
}
