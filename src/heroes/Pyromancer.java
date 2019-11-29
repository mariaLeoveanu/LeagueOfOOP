package heroes;

public class Pyromancer extends Hero {
    Pyromancer(int x, int y) {
        super(x, y);
        hp = 500;
        maxHP = 500;
        name = 'P';
        healthPerLevel = 50;
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        int damageFireblast = 350 + 50 * level;
        int damageIgnite = 150 + 20 * level;
        int dmgPerRound = 50 + 30 * level;
        float fDamageFireblast = damageFireblast;
        float fDamageIgnite = damageIgnite;
        // order of modifiers: LAND, RACE
        if(map[this.x][this.y] == 'V'){
            fDamageFireblast = damageFireblast * 1.25f;
            fDamageIgnite = damageIgnite * 1.25f;
            dmgPerRound = Math.round(dmgPerRound * 1.25f);
        }
        damageWoRaceModif = Math.round(fDamageFireblast + fDamageIgnite);

        if (Rogue.class.equals(hero.getClass())) {
            damageFireblast = Math.round(0.8f * fDamageFireblast);
            damageIgnite = Math.round(fDamageIgnite * 0.8f);
            dmgPerRound = Math.round(dmgPerRound * 0.8f);
        }
        if (Knight.class.equals(hero.getClass())) {
            damageFireblast = Math.round(1.2f * fDamageFireblast);
            damageIgnite = Math.round(fDamageIgnite * 1.2f);
            dmgPerRound = Math.round(dmgPerRound * 1.2f);
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            damageFireblast = Math.round(0.9f * fDamageFireblast);
            damageIgnite = Math.round(fDamageIgnite * 0.9f);
            dmgPerRound = Math.round(dmgPerRound * 0.9f);
        }
        if (Wizard.class.equals(hero.getClass())) {
            damageFireblast = Math.round(1.05f * fDamageFireblast);
            damageIgnite = Math.round(fDamageIgnite * 1.05f);
            dmgPerRound = Math.round(dmgPerRound * 1.05f);
        }
        hero.otDmg.numRounds = 2;
        hero.otDmg.dmgPerRound = dmgPerRound;
        if(hero.hp < damageFireblast + damageIgnite){
            hero.hp = 0;
        }else {
            hero.hp = hero.hp - damageFireblast - damageIgnite;
        }
        hero.wasAttackedThisRound = true;

    }

}
