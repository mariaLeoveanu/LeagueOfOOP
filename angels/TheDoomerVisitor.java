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
        k.setHp(0);
    }

    @Override
    public void apply(Pyromancer p) {
        p.setHp(0);
    }

    @Override
    public void apply(Wizard w) {
        w.setHp(0);
    }

    @Override
    public void apply(Rogue r) {
        r.setHp(0);
    }


}
