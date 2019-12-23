package heroes;

import angels.Visitor;
import fileio.implementations.FileWriter;
import main.Constants;
import strategy.Strategy;
import strategy.StrategyFactory;

import java.io.IOException;

public class Wizard extends Hero {
    Wizard(final int x, final int y, int id) {
        super(x, y, id);
        setHp(Constants.WIZARD_BASE_HP);
        setMaxHP(Constants.WIZARD_BASE_HP);
        setHealthPerLevel(Constants.WIZARD_HP_PER_LEVEL);
        setName('W');
        this.type = "Wizard";
    }
    @Override
    public void chooseStrategy() {
        StrategyFactory strategyFactory = new StrategyFactory();
        this.chosenStrategy = strategyFactory.getStrategy(this);
        if(this.chosenStrategy != null){
            this.chosenStrategy.applyStrategy(this);
        }
    }

    @Override
    public final void attack(final Hero hero, final char[][] map) {

        //check if racemodifers stacks or resets
        float drainPc = Constants.DRAIN_BASE_PERCENTAGE + Constants.DRAIN_P_PER_ROUND * getLevel();
        float deflectPc = Constants.DEFLECT_BASE_PERCENTAGE
                + Constants.DEFLECT_P_PER_ROUND * getLevel() ;
        int drainDamage;
        int deflectDamage = 0;

        if (Rogue.class.equals(hero.getClass())) {
            drainPc = drainPc * (Constants.DRAIN_ROGUE_MULTIPLIER + this.raceModifierChange);
            deflectDamage = Math.round(Math.round(deflectPc * hero.getDamageWoRaceModif())
                    * (Constants.DEFLECT_ROGUE_MULTIPLIER + this.raceModifierChange));
        }
        if (Knight.class.equals(hero.getClass())) {
            drainPc = drainPc * (Constants.DRAIN_KNIGHT_MULTIPLIER + this.raceModifierChange);
            deflectDamage = Math.round(Math.round(deflectPc * hero.getDamageWoRaceModif())
                    * (Constants.DEFLECT_KNIGHT_MULTIPLIER + this.raceModifierChange));
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            drainPc = drainPc * (Constants.DRAIN_PYROMANCER_MULTIPLIER + this.raceModifierChange);
            deflectDamage = Math.round(Math.round(deflectPc * hero.getDamageWoRaceModif())
                    * (Constants.DEFLECT_PYROMANCER_MULTIPLIER + this.raceModifierChange));
        }
        if (Wizard.class.equals(hero.getClass())) {
            drainPc = drainPc * (Constants.DRAIN_WIZARD_MULTIPLIER + this.raceModifierChange);
            deflectDamage = 0;
        }

        if (map[this.getX()][this.getY()] == 'D') {
            drainPc = drainPc * Constants.WIZARD_LAND_MULTIPLIER;
            deflectDamage = Math.round(deflectDamage * Constants.WIZARD_LAND_MULTIPLIER);
        }
        drainDamage = Math.round(drainPc
                * Math.min(Constants.DRAIN_MAX_HP_MULTIPLIER * hero.getMaxHP(), hero.getHp()));

        if (hero.getHp() < deflectDamage + drainDamage) {
            hero.setHp(0);
        } else {
            hero.setHp(hero.getHp() - deflectDamage - drainDamage);
        }

        hero.setWasAttackedThisRound(true);


    }

    @Override
    public void accept(Visitor v, FileWriter fileWriter) throws IOException {
        v.apply(this, fileWriter);
    }
}
