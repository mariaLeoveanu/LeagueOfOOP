package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngelVisitor extends Visitor {
    LevelUpAngelVisitor(int x, int y) {
        super(x, y);
        name = "LevelUpAngel";
        actionType = "helped";
    }

    @Override
    public void apply(Knight k) {
        k.setXp(250 + k.getLevel() * 50 - k.getXp());
        k.tryLevelUp();
        k.raceModifierChange += 0.1f;
    }

    @Override
    public void apply(Pyromancer p) {
       p.setXp(250 + p.getLevel() * 50);
       p.tryLevelUp();
       p.raceModifierChange += 0.2f;
    }

    @Override
    public void apply(Wizard w) {
        w.setXp(250 + w.getLevel() * 50);
        w.tryLevelUp();
        w.raceModifierChange += 0.25f;
    }

    @Override
    public void apply(Rogue r) {
        r.setXp(250 + r.getLevel() * 50);
        r.tryLevelUp();
        r.raceModifierChange += 0.15f;
    }


}
