package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoyVisitor extends Visitor {
    GoodBoyVisitor(int x, int y) {
        super(x, y);
        this.actionType = "helped";
        this.name = "GoodBoy";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.raceModifierChange += 0.4f;
            k.setHp(Math.max(k.getMaxHP(), k.getHp() + 20));
            Visitor.magician.updateAction(this, k, k.id);
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.raceModifierChange += 0.5f;
            p.setHp(Math.max(p.getMaxHP(), p.getHp() + 30));
            Visitor.magician.updateAction(this, p, p.id);
        }

    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() > 0){
            w.raceModifierChange += 0.3f;
            w.setHp(Math.max(w.getMaxHP(), w.getHp() + 50));
            Visitor.magician.updateAction(this, w, w.id);
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.raceModifierChange += 0.4f;
            r.setHp(Math.max(r.getMaxHP(), r.getHp() + 40));
            Visitor.magician.updateAction(this, r, r.id);
        }

    }


}
