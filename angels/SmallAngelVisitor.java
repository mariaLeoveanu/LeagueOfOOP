package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngelVisitor extends Visitor {
    SmallAngelVisitor(int x, int y) {
        super(x, y);
        this.name = "SmallAngel";
        this.actionType = "helped";
    }

    @Override
    public void apply(Knight k) {
        k.raceModifierChange += 0.1f;
        k.setHp(k.getHp() + 10);
    }

    @Override
    public void apply(Pyromancer p) {
        p.raceModifierChange += 0.15f;
        p.setHp(p.getHp() + 15);
    }

    @Override
    public void apply(Wizard w) {
        w.raceModifierChange +=0.1f;
        w.setHp(w.getHp() + 25);
    }

    @Override
    public void apply(Rogue r) {
        r.raceModifierChange += 0.05f;
        r.setHp(r.getHp() + 20);
    }


}
