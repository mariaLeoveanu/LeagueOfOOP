package angels;

import heroes.*;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Visitor {
    int x;
    int y;
    String name;
    String actionType;
    Visitor(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void apply(Knight k);
    public abstract void apply(Pyromancer p);
    public abstract void apply(Wizard w);
    public abstract void apply(Rogue r);

    public abstract void update(char playerType, int playerID);
    public ArrayList<Integer> checkForHeroes(ArrayList<Hero> heroes){
        ArrayList<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < heroes.size(); i++){
            if(heroes.get(i).getX() == this.x &&
            heroes.get(i).getY() == this.y){
                neighbours.add(i);
            }
        }
        return neighbours;
    }


}
