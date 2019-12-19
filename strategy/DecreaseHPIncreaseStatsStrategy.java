package strategy;

import heroes.*;

public class DecreaseHPIncreaseStatsStrategy implements Strategy{

    @Override
    public void applyStrategy(Knight knight) {
        knight.setHp(knight.getHp() - knight.getHp()/5);
        // we are going to add this in Knight class when
        // computing the damage with ace modifier
        knight.raceModifierChange = 0.5f;
    }

    @Override
    public void applyStrategy(Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - pyromancer.getHp()/4);
        pyromancer.raceModifierChange = 0.7f;
    }

    @Override
    public void applyStrategy(Rogue rogue) {
        rogue.setHp(rogue.getHp() - rogue.getHp()/7);
        rogue.raceModifierChange = 0.4f;
    }

    @Override
    public void applyStrategy(Wizard wizard) {
        wizard.setHp(wizard.getHp() - wizard.getHp()/10);
        wizard.raceModifierChange = 0.6f;
    }
}
