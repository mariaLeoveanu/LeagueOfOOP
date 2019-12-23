package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomerVisitor extends Visitor {
    TheDoomerVisitor(int x, int y) {
        super(x, y);
        this.actionType = "hit";
        this.name = "TheDoomer";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.setHp(0);
            Visitor.magician.updateAction(this, k, k.id);
            Visitor.magician.updateAngelKilled(k, k.id);
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.setHp(0);
            Visitor.magician.updateAction(this, p, p.id);
            Visitor.magician.updateAngelKilled(p, p.id);
        }

    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() > 0){
            w.setHp(0);
            Visitor.magician.updateAction(this, w, w.id);
            Visitor.magician.updateAngelKilled(w, w.id);
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.setHp(0);
            Visitor.magician.updateAction(this, r, r.id);
            Visitor.magician.updateAngelKilled(r, r.id);
        }

    }


}
