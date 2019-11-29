package heroes;


public class Knight extends Hero {
    Knight(int x, int y) {
        super(x, y);
        hp = 900;
        maxHP = 900;
        name = 'K';
        healthPerLevel = 80;
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        int executeDamage = 200 + 30 * level;
        int slamDamage = 100 + 40 * level;

        //order of modifiers LAND, RACE
        if (map[this.x][this.y] == 'L') {
            executeDamage = Math.round(executeDamage * 1.15f);
            slamDamage = Math.round(slamDamage * 1.15f);
        }
        //execute
        float hpLimit = (0.2f + 0.01f * level) * hero.maxHP;
        if (hero.hp < hpLimit) {
            executeDamage = hero.hp;
            hero.hp = 0;
            damageWoRaceModif = executeDamage + slamDamage;
        } else {
            damageWoRaceModif =  executeDamage + slamDamage;
            if (Rogue.class.equals(hero.getClass())) {
                executeDamage = Math.round(executeDamage * 1.15f);
                slamDamage = Math.round(slamDamage * 0.8f);
            }
            if (Knight.class.equals(hero.getClass())) {
                slamDamage = Math.round(slamDamage * 1.2f);
            }
            if (Pyromancer.class.equals(hero.getClass())) {
                executeDamage = Math.round(executeDamage * 1.1f);
                slamDamage = Math.round(slamDamage * 0.9f);
            }
            if (Wizard.class.equals(hero.getClass())) {
                executeDamage = Math.round(executeDamage * 0.8f);
                slamDamage = Math.round(slamDamage * 1.05f);
            }

            hero.paralysed = 1;
            // reset any overtime damage that was before
            hero.otDmg.numRounds = 0;
            hero.otDmg.dmgPerRound = 0;
            if(hero.hp < executeDamage + slamDamage){
                hero.hp = 0;
            }else {
                hero.hp = hero.hp - executeDamage - slamDamage;
            }

        }
        hero.wasAttackedThisRound = true;
    }
}
