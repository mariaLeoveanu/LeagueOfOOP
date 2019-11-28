package heroes;

public class Rogue extends Hero {
    int streak;
    Rogue(int x, int y) {
        super(x, y);
        hp = 600;
        maxHP = 600;
        streak = 0;
        name = 'R';
    }

    @Override
    public void attack(Hero hero, char[][] map) {
        int backstabDamage = 200 + 20 * level;
        int paralysisDamage = 40 + 10 * level;
        if (Rogue.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.2f);
            paralysisDamage = Math.round(paralysisDamage * 0.9f);
            streak++;
        }
        if (Knight.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 0.9f);
            paralysisDamage = Math.round(paralysisDamage * 0.8f);
            streak++;
        }
        if (Pyromancer.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.25f);
            paralysisDamage = Math.round(paralysisDamage * 1.2f);
            streak++;
        }
        if (Wizard.class.equals(hero.getClass())) {
            backstabDamage = Math.round(backstabDamage * 1.25f);
            paralysisDamage = Math.round(paralysisDamage * 1.25f);
            streak++;
        }
        if (this.streak == 3 && map[this.x][this.y] == 'W') {
            backstabDamage = Math.round(backstabDamage * 1.5f);
            streak = 0;
        } else if (streak == 3) {
            streak = 0;
        }

        if(map[this.x][this.y] == 'W'){
            backstabDamage = Math.round(backstabDamage * 1.15f);
            paralysisDamage = Math.round(paralysisDamage * 1.15f);
            hero.paralysed = 6;
        } else {
            hero.paralysed = 3;
        }
        hero.hp = hero.hp - backstabDamage - paralysisDamage;
        hero.otDmg.numRounds = hero.paralysed;
        hero.otDmg.dmgPerRound = paralysisDamage;
        hero.wasAttackedThisRound = true;
        if(hero.hp < 0){
            hero.hp = 0;
        }
    }
}
