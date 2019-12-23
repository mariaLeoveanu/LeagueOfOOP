package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class LifeGiverVisitor extends Visitor  {
    LifeGiverVisitor(int x, int y) throws IOException {
        super(x, y);
        name = "LifeGiver";
        actionType = "helped";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if (k.getHp() > 0){
            k.setHp(Math.min(k.getMaxHP(), k.getHp() + 100));
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if (p.getHp() > 0){
            p.setHp(Math.min(p.getMaxHP(), p.getHp() + 80));
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
        }
    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if (w.getHp() > 0){
            w.setHp(Math.min(w.getMaxHP(), w.getHp() + 120));
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
        }
    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if (r.getHp() > 0){
            r.setHp(Math.min(r.getMaxHP(), r.getHp() + 90));
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
        }
    }




}
