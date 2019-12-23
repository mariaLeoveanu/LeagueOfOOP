package main;

import angels.Visitor;
import heroes.Hero;

public class Magician {
    public void updateAction(Visitor angel, Hero hero , int idHero){
        System.out.println(angel.name + " " + angel.actionType + " " + hero.type + " " + idHero);
    }

    public void updateSpawn(Visitor angel){
        System.out.println("Angel " + angel.name + " was spawned at " + angel.x + " " + angel.y);
    }

    public void updateHeroKilled(Hero killer, Hero killed, int idKiller, int idKilled){
        System.out.println("Player " + killed.type + " " + idKilled + " was killed by " + killer.type + " " + idKiller);
    }

    public void updateAngelKilled(Hero killed, int idKilled){

    }
}
