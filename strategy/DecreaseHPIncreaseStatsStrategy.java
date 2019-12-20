package strategy;

import heroes.*;

public class DecreaseHPIncreaseStatsStrategy implements Strategy{

    @Override
    public void applyStrategy(Hero hero) {
        if(hero.getClass().equals(Knight.class)) {
            hero.setHp(hero.getHp() - hero.getHp() / 5);
            // we are going to add this in Knight class when
            // computing the damage with ace modifier
            hero.raceModifierChange += 0.5f;
        }
        if(hero.getClass().equals(Pyromancer.class)){
            hero.setHp(hero.getHp() - hero.getHp()/4);
            hero.raceModifierChange += 0.7f;
        }
        if(hero.getClass().equals(Rogue.class)){
            hero.setHp(hero.getHp() - hero.getHp()/7);
            hero.raceModifierChange += 0.4f;
        }
        if(hero.getClass().equals(Wizard.class)){
            hero.setHp(hero.getHp() - hero.getHp()/10);
            hero.raceModifierChange += 0.6f;
        }
    }

}
