package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngelVisitor extends Visitor{
    XPAngelVisitor(int x, int y) {
        super(x, y);
        this.actionType = "helped";
        this.name = "XPAngel";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.setXp(k.getXp() + 45);
            Visitor.magician.updateAction(this, k, k.id);
            k.tryLevelUp();
        }

    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.setXp(p.getXp() + 50);
            Visitor.magician.updateAction(this, p, p.id);
            p.tryLevelUp();
        }

    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() > 0){
            w.setXp(w.getXp() + 60);
            Visitor.magician.updateAction(this, w, w.id);
            w.tryLevelUp();
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.setXp(r.getXp() + 40);
            Visitor.magician.updateAction(this, r, r.id);
            r.tryLevelUp();
        }

    }


}
