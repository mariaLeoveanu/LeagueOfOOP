package angels;

import heroes.*;
import main.Magician;

import java.util.ArrayList;

public abstract class Visitor {
    public int x;
    public int y;
    public String name;
    public String actionType;
    public static Magician magician;
    Visitor(int x, int y){
        this.x = x;
        this.y = y;
        magician = new Magician();
    }
    public abstract void apply(Knight k);
    public abstract void apply(Pyromancer p);
    public abstract void apply(Wizard w);
    public abstract void apply(Rogue r);

    public void spawn(){
        Visitor.magician.updateSpawn(this);
    }

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
