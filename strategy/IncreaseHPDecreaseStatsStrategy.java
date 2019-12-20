package strategy;

import heroes.*;

public class IncreaseHPDecreaseStatsStrategy implements Strategy {

    @Override
    public void applyStrategy(Hero hero) {
        if(hero.getClass().equals(Knight.class)){
            hero.setHp(hero.getHp() + hero.getHp()/4);
            // we are going to add this in Knight class when
            // computing the damage with ace modifier
            hero.raceModifierChange += -0.2f;
        }
        if (hero.getClass().equals(Pyromancer.class)){
            hero.setHp(hero.getHp() + hero.getHp()/3);
            hero.raceModifierChange += -0.3f;
        }
        if(hero.getClass().equals(Rogue.class)){
            hero.setHp(hero.getHp() + hero.getHp()/2);
            hero.raceModifierChange += -0.1f;
        }
        if (hero.getClass().equals(Wizard.class)){
            hero.setHp(hero.getHp() + hero.getHp()/5);
            hero.raceModifierChange += -0.2f;
        }
    }

}
