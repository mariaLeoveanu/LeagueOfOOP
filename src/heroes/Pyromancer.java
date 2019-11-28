package heroes;

public class Pyromancer extends Hero {
    Pyromancer(int x, int y) {
        super(x, y);
        hp = 500;
        maxHP = 500;
        name = 'P';
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        int damageFireblast = 350 + 50 * level;
        int damageIgnite = 150 + 20 * level;
        // order of modifiers: LAND, RACE
        if(map[this.x][this.y] == 'V'){
            damageFireblast = Math.round(damageFireblast * 1.25f);
            damageIgnite = Math.round(damageIgnite * 1.25f);
        }
        damageWoRaceModif = damageFireblast + damageIgnite;

        if (Rogue.class.equals(hero.getClass())) {
            damageFireblast = Math.round(0.8f * damageFireblast);
            damageIgnite = Math.round(damageIgnite * 0.8f);
            hero.otDmg.dmgPerRound = Math.round((50 + 30 * level) * 0.8f);
        }
        if (Knight.class.equals(hero.getClass())) {
            damageFireblast = Math.round(1.2f * damageFireblast);
            damageIgnite = Math.round(damageIgnite * 1.2f);
            hero.otDmg.dmgPerRound = Math.round((50 + 30 * level) * 1.2f);
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            damageFireblast = Math.round(0.9f * damageFireblast);
            damageIgnite += Math.round(damageIgnite * 0.9f);
            hero.otDmg.dmgPerRound = Math.round((50 + 30 * level) * 0.9f);
        }
        if (Wizard.class.equals(hero.getClass())) {
            damageFireblast = Math.round(1.05f * damageFireblast);
            damageIgnite = Math.round(damageIgnite * 1.05f);
            hero.otDmg.dmgPerRound = Math.round((50 + 30 * level) * 1.05f);
        }

        if(hero.hp < damageFireblast + damageIgnite){
            hero.hp = 0;
        }else {
            hero.hp = hero.hp - damageFireblast - damageIgnite;
        }
        hero.wasAttackedThisRound = true;
        hero.otDmg.numRounds = 2;
    }

}
