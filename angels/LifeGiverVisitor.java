package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiverVisitor extends Visitor  {
    LifeGiverVisitor(int x, int y) {
        super(x, y);
        name = "LifeGiver";
        actionType = "helped";
    }


    @Override
    public void apply(Knight k) {
      //  System.out.println("Knight - Initial HP:" + k.getHp());
        k.setHp(k.getHp() + 100);
      //  System.out.println("Knght - Final HP:" + k.getHp());
    }

    @Override
    public void apply(Pyromancer p) {
       // System.out.println("Pyro - Initial HP:" + p.getHp());
        p.setHp(p.getHp() + 80);
       // System.out.println("Pyro - Initial HP:" + p.getHp());
    }

    @Override
    public void apply(Wizard w) {
        w.setHp(w.getHp() + 120);
    }

    @Override
    public void apply(Rogue r) {
        r.setHp(r.getHp() + 90);
    }




}
