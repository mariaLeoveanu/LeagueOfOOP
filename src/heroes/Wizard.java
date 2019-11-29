package heroes;

public class Wizard extends Hero {
    Wizard(int x, int y) {
        super(x, y);
        hp = 400;
        maxHP = 400;
        healthPerLevel = 30;
        name = 'W';
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        float drainPc = 0.2f + 0.05f * level;
        float deflectPc = 0.35f + 0.02f * level;
        int drainDamage = 1;
        int deflectDamage = 0;
        if (Rogue.class.equals(hero.getClass())) {
            drainPc = drainPc * 0.8f;
            deflectDamage = Math.round(Math.round(deflectPc * hero.damageWoRaceModif) * 1.2f);
        }
        if (Knight.class.equals(hero.getClass())) {
            drainPc = drainPc * 1.2f;
            deflectDamage = Math.round(Math.round(deflectPc * hero.damageWoRaceModif) * 1.4f);
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            drainPc = drainPc * 0.9f;
            deflectDamage = Math.round(Math.round(deflectPc * hero.damageWoRaceModif) * 1.3f);
        }
        if (Wizard.class.equals(hero.getClass())) {
            drainPc = drainPc * 1.05f;
            deflectDamage = 0;
        }
        if(map[this.x][this.y] == 'D'){
            drainPc = drainPc * 1.1f;
            deflectDamage = Math.round(deflectDamage * 1.1f);
        }
        drainDamage = Math.round(drainPc * Math.min(0.3f * hero.maxHP, hero.hp));

        if(hero.hp < deflectDamage + drainDamage){
            hero.hp = 0;
        }else{
            hero.hp = hero.hp - deflectDamage - drainDamage;
        }

        hero.wasAttackedThisRound = true;



    }
}
