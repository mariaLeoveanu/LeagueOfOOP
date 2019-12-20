package heroes;

import angels.Visitor;
import main.Constants;
import strategy.StrategyFactory;

public final class Pyromancer extends Hero {
    Pyromancer(final int x, final int y) {
        super(x, y);
        setHp(Constants.PYROMANCER_BASE_HP);
        setMaxHP(Constants.PYROMANCER_BASE_HP);
        setName('P');
        setHealthPerLevel(Constants.PYROMANCER_HP_PER_LEVEL);
    }

    @Override
    public void attack(final Hero hero, final char[][] map) {

        int damageFireblast =
            Constants.FIREBLAST_BASE_DAMAGE + Constants.FIREBLAST_DAMAGE_PER_LEVEL * getLevel();
        int damageIgnite =
            Constants.IGNITE_BASE_DAMAGE + Constants.IGNITE_DAMAGE_PER_LEVEL * getLevel();
        int dmgPerRound =
            Constants.IGNITE_DAMAGE_OVERTIME
                    + Constants.IGNITE_DAMAGE_OVERTIME_PER_LEVEL * getLevel();

        //float variables to store the damage without race modifiers
        float fDamageFireblast = damageFireblast;
        float fDamageIgnite = damageIgnite;

        // order of modifiers: LAND, RACE
        if (map[this.getX()][this.getY()] == 'V') {

            // set bonus for all abilities including overtime ignite
            fDamageFireblast = Math.round(damageFireblast * Constants.PYROMANCER_LAND_MULTIPLIER);
            fDamageIgnite = Math.round(damageIgnite * Constants.PYROMANCER_LAND_MULTIPLIER);
            dmgPerRound = Math.round(dmgPerRound * Constants.PYROMANCER_LAND_MULTIPLIER);
        }
        // add race multipliers
        if (Rogue.class.equals(hero.getClass())) {
            damageFireblast =
                 Math.round(fDamageFireblast * (Constants.PYROMANCER_ABILITY_ROGUE_MULTIPLIER + this.raceModifierChange));
            damageIgnite =
                 Math.round(fDamageIgnite * (Constants.PYROMANCER_ABILITY_ROGUE_MULTIPLIER + this.raceModifierChange));
            dmgPerRound =
                 Math.round(dmgPerRound * (Constants.PYROMANCER_ABILITY_ROGUE_MULTIPLIER + this.raceModifierChange));
        }
        if (Knight.class.equals(hero.getClass())) {
            damageFireblast =
                    Math.round(fDamageFireblast * (Constants.PYROMANCER_ABILITY_KNIGHT_MULTIPLIER + this.raceModifierChange));
            damageIgnite =
                    Math.round(fDamageIgnite * (Constants.PYROMANCER_ABILITY_KNIGHT_MULTIPLIER+ this.raceModifierChange));
            dmgPerRound =
                    Math.round(dmgPerRound * (Constants.PYROMANCER_ABILITY_KNIGHT_MULTIPLIER+ this.raceModifierChange));
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            damageFireblast =
                 Math.round(fDamageFireblast * (Constants.PYROMANCER_ABILITY_PYROMANCER_MULTIPLIER+ this.raceModifierChange));
            damageIgnite =
                 Math.round(fDamageIgnite * (Constants.PYROMANCER_ABILITY_PYROMANCER_MULTIPLIER+ this.raceModifierChange));
            dmgPerRound =
                 Math.round(dmgPerRound * (Constants.PYROMANCER_ABILITY_PYROMANCER_MULTIPLIER+ this.raceModifierChange));
        }
        if (Wizard.class.equals(hero.getClass())) {
            //if hero is wizard, save the damage without race modifier
            setDamageWoRaceModif(Math.round(fDamageFireblast + fDamageIgnite));
            damageFireblast =
                    Math.round(fDamageFireblast * (Constants.PYROMANCER_ABILITY_WIZARD_MULTIPLIER+ this.raceModifierChange));
            damageIgnite =
                    Math.round(fDamageIgnite * (Constants.PYROMANCER_ABILITY_WIZARD_MULTIPLIER+ this.raceModifierChange));
            dmgPerRound =
                    Math.round(dmgPerRound * (Constants.PYROMANCER_ABILITY_WIZARD_MULTIPLIER+ this.raceModifierChange));
        }
        // set overtime info
        hero.getOtDmg().setNumRounds(2);
        hero.getOtDmg().setDmgPerRound(dmgPerRound);

        if (hero.getHp() < damageFireblast + damageIgnite) {
            hero.setHp(0);
        } else {
            hero.setHp(hero.getHp() - damageFireblast - damageIgnite);
        }
        System.out.println("Damage Pyro: " + damageFireblast + " " +  damageIgnite);

        hero.setWasAttackedThisRound(true);

    }

    @Override
    public void accept(Visitor v) {
        v.apply(this);
    }

}
