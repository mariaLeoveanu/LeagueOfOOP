package strategy;

import heroes.*;

public class IncreaseHPDecreaseStatsStrategy implements Strategy {

    @Override
    public void applyStrategy(Knight knight) {
        knight.setHp(knight.getHp() + knight.getHp()/4);
        // we are going to add this in Knight class when
        // computing the damage with ace modifier
        knight.raceModifierChange = -0.2f;
    }

    @Override
    public void applyStrategy(Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() + pyromancer.getHp()/3);
        pyromancer.raceModifierChange = -0.3f;
    }

    @Override
    public void applyStrategy(Rogue rogue) {
        rogue.setHp(rogue.getHp() + rogue.getHp()/2);
        rogue.raceModifierChange = -0.1f;
    }

    @Override
    public void applyStrategy(Wizard wizard) {
        wizard.setHp(wizard.getHp() + wizard.getHp()/5);
        wizard.raceModifierChange = -0.2f;
    }
}
