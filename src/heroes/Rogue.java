package heroes;

public class Rogue extends Hero {
    private int streak;
    private char previousLand;
    Rogue(int x, int y) {
        super(x, y);
        hp = 600;
        maxHP = 600;
        streak = 0;
        name = 'R';
        previousLand = 'D';
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        int backstabDamage = 200 + 20 * level;
        int paralysisDamage = 40 + 10 * level;
        // order of bonuses: CRITICAL, LAND, RACE

        if(previousLand != 'W' && map[this.x][this.y] == 'W'){
            //first round in woods -> critical
            backstabDamage = Math.round(backstabDamage * 1.5f);
            streak++;
        }
        if(streak < 3 && map[this.x][this.y] == 'W'){
            // streak is not lost while remaining in woods
            streak++;
        }
        if(streak == 3 && map[this.x][this.y] == 'W'){
            // at 3 hits -> critical, then streak is reset
            backstabDamage = Math.round(backstabDamage * 1.5f);
            streak = 0;
        }
        if(map[this.x][this.y] != 'W'){
            // when not in woods streak stays 0
            streak = 0;
           hero.paralysed = 3;
        } else {
           hero.paralysed = 6;
        }

        damageWoRaceModif = backstabDamage + paralysisDamage;

        // add race bonus
        if (Rogue.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.2f);
            paralysisDamage = Math.round(paralysisDamage * 0.9f);
        }
        if (Knight.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 0.9f);
            paralysisDamage = Math.round(paralysisDamage * 0.8f);
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.25f);
            paralysisDamage = Math.round(paralysisDamage * 1.2f);
        }
        if (Wizard.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.25f);
            paralysisDamage = Math.round(paralysisDamage * 1.25f);
        }
        // modify opponent hp
        if(hero.hp < backstabDamage + paralysisDamage){
            hero.hp = 0;
        }else {
            hero.hp = hero.hp - backstabDamage - paralysisDamage;
        }

        // give overtime damage
        hero.otDmg.numRounds = hero.paralysed;
        hero.otDmg.dmgPerRound = paralysisDamage;
        hero.wasAttackedThisRound = true;

        previousLand = map[this.x][this.y];
    }
}
