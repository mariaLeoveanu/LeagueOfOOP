package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DraculaVisitor extends Visitor {
    DraculaVisitor(int x, int y) {
        super(x, y);
        this.actionType = "hit";
        this.name = "Dracula";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.raceModifierChange += -0.2f;
            k.setHp(Math.max(0, k.getHp() - 60));
            Visitor.magician.updateAction(this, k, k.id);
            if(k.getHp() == 0){
                Visitor.magician.updateAngelKilled(k, k.id);
            }
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.raceModifierChange += -0.3f;
            p.setHp(p.getHp() - 40);
            Visitor.magician.updateAction(this, p, p.id);
            if(p.getHp() == 0){
                Visitor.magician.updateAngelKilled(p, p.id);
            }
        }

    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() > 0){
            w.raceModifierChange += -0.4f;
            w.setHp(w.getHp() - 20);
            Visitor.magician.updateAction(this, w, w.id);
            if(w.getHp() == 0){
                Visitor.magician.updateAngelKilled(w, w.id);
            }
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.raceModifierChange += -0.1f;
            r.setHp(r.getHp() - 35);
            Visitor.magician.updateAction(this, r, r.id);
            if(r.getHp() == 0){
                Visitor.magician.updateAngelKilled(r, r.id);
            }
        }
    }

}
