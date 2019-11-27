package heroes;

import com.company.CustomPair;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Hero {
    public int x;
    public int y;
    public int xp;
    public int hp;
    public int maxHP;
    public int damageWoRaceModif;
    int level;
    boolean canMove;
    CustomPair otDmg;
    Hero(int x, int y){
        this.x = x;
        this.y = y;
        xp = 0;
        level = 0;
        canMove = true;
        damageWoRaceModif = 0;
        otDmg = new CustomPair(0,0);
    }
    public void checkOtDmg(){
        if(otDmg.numRounds > 0){
            this.hp -= otDmg.dmgPerRound;
            otDmg.numRounds --;
        }
    }
    public void move(char c){
        if(canMove && hp > 0){
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
        }
    }
    public int checkForOpponents(ArrayList<Hero> allPlayers, int playerID){
        for(int i = 0; i < allPlayers.size(); i++){
            if(i != playerID &&
               this.x == allPlayers.get(i).x &&
               this.y == allPlayers.get(i).y &&
               allPlayers.get(i).hp > 0){
                return i;
            }
        }
        return  -1;
    }
    public abstract void attack(Hero hero, char[][] map);

}
