package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngelVisitor extends Visitor{
    DamageAngelVisitor(int x, int y) {
        super(x, y);
        this.actionType = "helped";
        this.name = "DamageAngel";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.raceModifierChange += 0.15f;
            Visitor.magician.updateAction(this, k, k.id);
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.raceModifierChange += 0.2f;
            Visitor.magician.updateAction(this, p, p.id);
        }

    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() > 0){
            w.raceModifierChange += 0.4f;
            Visitor.magician.updateAction(this, w, w.id);
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.raceModifierChange += 0.3f;
            Visitor.magician.updateAction(this, r, r.id);
        }

    }


}
