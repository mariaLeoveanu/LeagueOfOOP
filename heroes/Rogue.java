package heroes;

import main.Constants;

public class Rogue extends Hero {
    private int streak;
    // store the previous land rogue was on
    private char previousLand;

    Rogue(final int x, final int y) {
        super(x, y);
        setHp(Constants.ROGUE_BASE_HP);
        setMaxHP(Constants.ROGUE_BASE_HP);
        streak = 0;
        setHealthPerLevel(Constants.ROGUE_HP_PER_LEVEL);
        setName('R');
        previousLand = 'D';
    }

    @Override
    public final void attack(final Hero hero, final char[][] map) {
        int backstabDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_DAMAGE_PER_LEVEL * getLevel();
        int paralysisDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_DAMAGE_PER_LEVEL * getLevel();

        // check for critical bonus
        if (map[this.getX()][this.getY()] == 'W') {
            // if it's for the first time on woods, after a different
            // type of land -> critical bonus
            if (previousLand != 'W') {
                backstabDamage = Math.round(backstabDamage * Constants.BACKSTAB_CRITICAL_BONUS);
                // keep streak
                streak++;
            } else if (streak < Constants.ROGUE_MAX_STREAK) {
                // if on woods but hasn't reached max streak, keep adding
                streak++;
            } else if (streak == Constants.ROGUE_MAX_STREAK) {
                backstabDamage = Math.round(backstabDamage * Constants.BACKSTAB_CRITICAL_BONUS);
                // reset streak
                streak = 0;
            }
        }

        if (map[this.getX()][this.getY()] != 'W') {
            // when not in woods. streak stays 0
            streak = 0;
            hero.setParalysed(Constants.ROGUE_PARALYSIS_MIN_ROUNDS);
        } else {
            hero.setParalysed(Constants.ROGUE_PARALYSIS_MAX_ROUNDS);
            backstabDamage = Math.round(backstabDamage * Constants.ROGUE_LAND_MULTIPLIER);
            paralysisDamage = Math.round(paralysisDamage * Constants.ROGUE_LAND_MULTIPLIER);
        }

        // add race bonus
        if (Rogue.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * Constants.BACKSTAB_ROGUE_MULTIPLIER);
            paralysisDamage = Math.round(paralysisDamage * Constants.PRALYSIS_ROGUE_MULTIPLIER);
        }
        if (Knight.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * Constants.BACKSTAB_KNIGHT_MULTIPLIER);
            paralysisDamage = Math.round(paralysisDamage * Constants.PRALYSIS_KNIGHT_MULTIPLIER);
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * Constants.BACKSTAB_PYROMANCER_MULTIPLIER);
            paralysisDamage = Math.round(paralysisDamage
                    * Constants.PRALYSIS_PYROMANCER_MULTIPLIER);
        }
        if (Wizard.class.equals(hero.getClass())) {
            setDamageWoRaceModif(backstabDamage + paralysisDamage);
            backstabDamage = Math.round(backstabDamage * Constants.ROGUE_ABILITY_WIZARD_BONUS);
            paralysisDamage = Math.round(paralysisDamage * Constants.ROGUE_ABILITY_WIZARD_BONUS);
        }

        // any existing overtime damage is reset
        // because all 3 flags are modified by these abilities
        hero.getOtDmg().setNumRounds(hero.getParalysed());
        hero.getOtDmg().setDmgPerRound(paralysisDamage);

        if (hero.getHp() < backstabDamage + paralysisDamage) {
            hero.setHp(0);
        } else {
            hero.setHp(hero.getHp() - backstabDamage - paralysisDamage);
        }

        hero.setWasAttackedThisRound(true);
        previousLand = map[this.getX()][this.getY()];
    }
}
