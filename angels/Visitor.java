package angels;

import heroes.*;

import java.util.ArrayList;

public abstract class Visitor {
    int x;
    int y;
    Visitor(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void apply(Knight k);
    public abstract void apply(Pyromancer p);
    public abstract void apply(Wizard w);
    public abstract void apply(Rogue r);

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
