package strategy;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class StrategyFactory {
    public Strategy getStrategy(Knight knight){
        if(knight.getMaxHP() / 3 < knight.getHp() &&
           knight.getHp() < (knight.getMaxHP() / 2)) {
            return new DecreaseHPIncreaseStatsStrategy();
        }
        if(knight.getHp() < knight.getMaxHP() / 3) {
            return new IncreaseHPDecreaseStatsStrategy();
        }
        return null;
    }
    public Strategy getStrategy(Pyromancer pyromancer){
        if(pyromancer.getMaxHP() / 4 < pyromancer.getHp() &&
           pyromancer.getHp() < pyromancer.getMaxHP() / 3){
            return new DecreaseHPIncreaseStatsStrategy();
        }
        if (pyromancer.getHp() < pyromancer.getMaxHP() / 4){
            return new IncreaseHPDecreaseStatsStrategy();
        }
        return null;
    }
    public Strategy getStrategy(Rogue rogue){
        if(rogue.getMaxHP() / 7 < rogue.getHp() &&
                rogue.getHp() < rogue.getMaxHP() / 5){
            return new DecreaseHPIncreaseStatsStrategy();
        }
        if (rogue.getHp() < rogue.getMaxHP() / 7){
            return new IncreaseHPDecreaseStatsStrategy();
        }
        return null;
    }
    public Strategy getStrategy(Wizard wizard){
        if(wizard.getMaxHP() / 4 < wizard.getHp() &&
                wizard.getHp() < wizard.getMaxHP() / 2){
            return new DecreaseHPIncreaseStatsStrategy();
        }
        if (wizard.getHp() < wizard.getMaxHP() / 4){
            return new IncreaseHPDecreaseStatsStrategy();
        }
        return null;
    }
}
