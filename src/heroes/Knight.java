package heroes;


import main.Constants;

public final class Knight extends Hero {
    Knight(final int x, final int y) {
        super(x, y);
        setHp(Constants.KNIGHT_BASE_HP);
        setMaxHP(Constants.KNIGHT_BASE_HP);
        setName('K');
        setHealthPerLevel(Constants.KNIGHT_HP_PER_LEVEL);
    }

    @Override
    public void attack(final Hero hero, final char[][] map) {
        int executeDamage = Constants.EXECUTE_BASE_DAMAGE
                            + Constants.EXECUTE_DAMAGE_PER_LEVEL * getLevel();
        int slamDamage = Constants.SLAM_BASE_DAMAGE + Constants.SLAM_DAMAGE_PER_LEVEL * getLevel();

        // first add land modifier
        if (map[this.getX()][this.getY()] == 'L') {
            executeDamage = Math.round(executeDamage * Constants.KNIGHT_LAND_MULTIPLIER);
            slamDamage = Math.round(slamDamage * Constants.KNIGHT_LAND_MULTIPLIER);
        }
        // check the minimum hp limit
        float hpLimit = (Constants.EXECUTE_BASE_HP_LIMIT
                        + Constants.EXECUTE_HP_LIMIT_PER_LEVEL * getLevel()) * hero.getMaxHP();
        if (hero.getHp() < hpLimit) {
            executeDamage = hero.getHp();
            hero.setHp(0);
            // if the opponent is a wizard, set the damage for deflect ability
            if (Wizard.class.equals(hero.getClass())) {
                setDamageWoRaceModif(executeDamage + slamDamage);
            }
        } else {
            if (Rogue.class.equals(hero.getClass())) {
                executeDamage = Math.round(executeDamage * Constants.EXECUTE_ROGUE_MULTIPLIER);
                slamDamage = Math.round(slamDamage * Constants.SLAM_ROGUE_MULTIPLIER);
            }
            if (Knight.class.equals(hero.getClass())) {
                slamDamage = Math.round(slamDamage * Constants.SLAM_KNIGHT_MULTIPLIER);
            }
            if (Pyromancer.class.equals(hero.getClass())) {
                executeDamage = Math.round(executeDamage * Constants.EXECUTE_PYROMANCER_MULTIPLIER);
                slamDamage = Math.round(slamDamage * Constants.SLAM_PYROMANCER_MULTIPLIER);
            }
            if (Wizard.class.equals(hero.getClass())) {
                // save the damage only for wizard opponent
                // as it is only accessed in wizard class
                setDamageWoRaceModif(executeDamage + slamDamage);
                executeDamage = Math.round(executeDamage * Constants.EXECUTE_WIZARD_MULTIPLIER);
                slamDamage = Math.round(slamDamage * Constants.SLAM_WIZARD_MULTIPLIER);
            }

            hero.setParalysed(1);

            // reset any overtime damage that was before
            hero.getOtDmg().setNumRounds(0);
            hero.getOtDmg().setDmgPerRound(0);

            if (hero.getHp() < executeDamage + slamDamage) {
                hero.setHp(0);
            } else {
                hero.setHp(hero.getHp() - executeDamage - slamDamage);
            }
        }
        hero.setWasAttackedThisRound(true);
    }
}
