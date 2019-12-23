package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class LevelUpAngelVisitor extends Visitor {
    LevelUpAngelVisitor(int x, int y) throws IOException {
        super(x, y);
        name = "LevelUpAngel";
        actionType = "helped";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if (k.getHp() > 0){
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            k.setXp(250 + k.getLevel() * 50 - k.getXp());
            k.tryLevelUp();
            k.raceModifierChange += 0.1f;
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            p.setXp(250 + p.getLevel() * 50);
            p.tryLevelUp();
            p.raceModifierChange += 0.2f;
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() > 0){
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            w.setXp(250 + w.getLevel() * 50);
            w.tryLevelUp();
            w.raceModifierChange += 0.25f;
        }

    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            r.setXp(250 + r.getLevel() * 50);
            r.tryLevelUp();
            r.raceModifierChange += 0.15f;
        }

    }


}
