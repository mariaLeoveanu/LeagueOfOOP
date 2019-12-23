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

    //todo: de verificat daca mor sa
    // afisez ca eroul a fost omorat de inger

    @Override
    public void apply(Knight k) {
        k.raceModifierChange += -0.2f;
        k.setHp(k.getHp() - 60);
    }

    @Override
    public void apply(Pyromancer p) {
        p.raceModifierChange += -0.3f;
        p.setHp(p.getHp() - 40);
    }

    @Override
    public void apply(Wizard w) {
        w.raceModifierChange += -0.4f;
        w.setHp(w.getHp() - 20);
    }

    @Override
    public void apply(Rogue r) {
        System.out.println("Rogue: " + r.getHp());
        r.raceModifierChange += -0.1f;
        r.setHp(r.getHp() - 35);
        System.out.println("Rogue: " + r.getHp());
    }

}
