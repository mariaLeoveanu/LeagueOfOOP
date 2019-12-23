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
        if (k.getHp() > 0){
            k.setHp(Math.min(k.getMaxHP(), k.getHp() + 100));
            Visitor.magician.updateAction(this, k, k.id);
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if (p.getHp() > 0){
            p.setHp(Math.min(p.getMaxHP(), p.getHp() + 80));
            Visitor.magician.updateAction(this, p, p.id);
        }
    }

    @Override
    public void apply(Wizard w) {
        if (w.getHp() > 0){
            w.setHp(Math.min(w.getMaxHP(), w.getHp() + 120));
            Visitor.magician.updateAction(this, w, w.id);
        }
    }

    @Override
    public void apply(Rogue r) {
        if (r.getHp() > 0){
            r.setHp(Math.min(r.getMaxHP(), r.getHp() + 90));
            Visitor.magician.updateAction(this, r, r.id);
        }
    }




}
