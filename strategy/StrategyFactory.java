package strategy;

import heroes.*;

public class StrategyFactory {
    public Strategy getStrategy(Hero hero){
        if (hero.getClass().equals(Knight.class)) {
            if (hero.getMaxHP() / 3 < hero.getHp() &&
                    hero.getHp() < (hero.getMaxHP() / 2)) {
                return new DecreaseHPIncreaseStatsStrategy();
            }
            if (hero.getHp() < hero.getMaxHP() / 3) {
                return new IncreaseHPDecreaseStatsStrategy();
            }

        }
        if(hero.getClass().equals(Pyromancer.class)){
            if(hero.getMaxHP() / 4 < hero.getHp() &&
                    hero.getHp() < hero.getMaxHP() / 3){
                return new DecreaseHPIncreaseStatsStrategy();
            }
            if (hero.getHp() < hero.getMaxHP() / 4){
                System.out.println(hero.getMaxHP()/4 + " < " + hero.getHp() + " < " + hero.getHp()/3 );
                return new IncreaseHPDecreaseStatsStrategy();
            }
        }
        if(hero.getClass().equals(Rogue.class)){
            if(hero.getMaxHP() / 7 < hero.getHp() &&
                    hero.getHp() < hero.getMaxHP() / 5){
                return new DecreaseHPIncreaseStatsStrategy();
            }
            if (hero.getHp() < hero.getMaxHP() / 7){
                return new IncreaseHPDecreaseStatsStrategy();
            }
        }
        if(hero.getClass().equals(Wizard.class)){
            if(hero.getMaxHP() / 4 < hero.getHp() &&
                    hero.getHp() < hero.getMaxHP() / 2){
                return new DecreaseHPIncreaseStatsStrategy();
            }
            if (hero.getHp() < hero.getMaxHP() / 4){
                return new IncreaseHPDecreaseStatsStrategy();
            }
        }
        return null;
    }
}
