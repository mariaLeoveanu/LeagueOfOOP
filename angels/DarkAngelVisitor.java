package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngelVisitor extends Visitor {
    DarkAngelVisitor(int x, int y) {
        super(x, y);
        this.actionType = "hit";
        this.name = "DarkAngel";
    }


    //todo: sa verific daca au hp 0 sa
    // afisez player x was killed by an angel si sa resetez hpul la 0


    @Override
    public void apply(Knight k) {
        if(k.getHp() > 0){
            k.setHp(k.getHp() - 40);
            Visitor.magician.updateAction(this, k, k.id);
            if(k.getHp() < 0){
                k.setHp(0);
            }
        }
    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() > 0){
            p.setHp(p.getHp() - 30);
            Visitor.magician.updateAction(this, p, p.id);
            if (p.getHp() < 0){
                p.setHp(0);
            }
        }

    }

    @Override
    public void apply(Wizard w) {
        if (w.getHp() > 0){
            w.setHp(w.getHp() - 20);
            Visitor.magician.updateAction(this, w, w.id);
            if(w.getHp() < 0){
                w.setHp(0);
            }
        }

    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() > 0){
            r.setHp(r.getHp() - 10);
            Visitor.magician.updateAction(this, r, r.id);
            if(r.getHp() < 0){
                r.setHp(0);
            }
        }
    }


}
