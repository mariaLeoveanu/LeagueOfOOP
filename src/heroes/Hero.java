package heroes;

import main.OvertimeInfo;

import java.util.ArrayList;

public abstract class Hero {
    public int x;
    public int y;
    public int xp;
    public int hp;
    public int maxHP;
    public int damageWoRaceModif;
    public int level;
    boolean canMove;
    public int paralysed;
    public boolean wasAttackedThisRound;
    public char name;
    public OvertimeInfo otDmg;
    int healthPerLevel;
    Hero(int x, int y){
        paralysed = 0;
        this.x = x;
        this.y = y;
        xp = 0;
        level = 0;
        wasAttackedThisRound = false;
        canMove = true;
        damageWoRaceModif = 0;
        otDmg = new OvertimeInfo(0,0);
    }
    public void checkOtDmg(){
        if( this.hp > 0 && otDmg.numRounds > 0){
            this.hp -= otDmg.dmgPerRound;
            otDmg.numRounds --;
            if(this.hp < 0){
                this.hp = 0;
            }
        }
    }
    public void move(char c){
        if(canMove && this.hp > 0 && paralysed <= 0){
            switch (c){
                case 'U':
                    this.x--;
                    break;
                case 'D':
                    this.x++;
                    break;
                case 'L':
                    this.y--;
                    break;
                case 'R':
                    this.y++;
                    break;
                case '_':
                    break;
            }
        } else {
            canMove = true;
            paralysed--;
        }
    }
    public int checkForOpponents(ArrayList<Hero> allPlayers, int playerID){
        if(this.hp <= 0 && !wasAttackedThisRound){
            return -1;
        }
        for(int i = 0; i < allPlayers.size(); i++){
            if(i != playerID &&
               this.x == allPlayers.get(i).x &&
               this.y == allPlayers.get(i).y &&
               allPlayers.get(i).hp > 0 && !allPlayers.get(i).wasAttackedThisRound){
                return i;
            }
        }
        return  -1;
    }
    public void checkIfOpponentKilled(Hero hero){
        if (hero.hp <= 0 && hero.wasAttackedThisRound){
            this.xp += Math.max(0, 200 - (this.level - hero.level) * 40);
        }
    }
    public void tryLevelUp(){
        int previousLevel = this.level;
        if(this.xp < 250){
            this.level = 0;
        } else {
            this.level = (this.xp - 250)/50 + 1;
            if(this.level != previousLevel){
                this.maxHP = this.maxHP + this.level * this.healthPerLevel;
                this.hp = this.maxHP;
            }
        }
    }
    public abstract void attack(Hero hero, char[][] map);

}
