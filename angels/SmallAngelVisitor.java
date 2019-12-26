package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class SmallAngelVisitor extends Visitor {
    SmallAngelVisitor(int x, int y) throws IOException {
        super(x, y);
        this.name = "SmallAngel";
        this.actionType = "helped";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if (k.getHp() > 0){
            k.raceModifierChange += 0.1f;
            k.setHp(Math.min(k.getMaxHP(), k.getHp() + 10));
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if (p.getHp() > 0){
            p.raceModifierChange += 0.15f;
            p.setHp(Math.min(p.getMaxHP(), p.getHp() + 15));
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
        }
    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if (w.getHp() > 0){
            w.raceModifierChange +=0.1f;
            w.setHp(Math.min(w.getMaxHP(), w.getHp() + 25));
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
        }
    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if (r.getHp() > 0){
            r.raceModifierChange += 0.05f;
            r.setHp(Math.min(r.getMaxHP(), r.getHp() + 20));
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
        }
    }


}
