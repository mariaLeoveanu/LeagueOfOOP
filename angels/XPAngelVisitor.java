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
        k.setXp(k.getXp() + 45);
    }

    @Override
    public void apply(Pyromancer p) {
        p.setXp(p.getXp() + 50);
    }

    @Override
    public void apply(Wizard w) {
        w.setXp(w.getXp() + 60);
    }

    @Override
    public void apply(Rogue r) {
        r.setXp(r.getXp() + 40);
    }


}
