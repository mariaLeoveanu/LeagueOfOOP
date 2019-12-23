package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class GoodBoyVisitor extends Visitor {
    GoodBoyVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "helped";
        this.name = "GoodBoy";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() > 0){
            k.raceModifierChange += 0.4f;
            k.setHp(Math.min(k.getMaxHP(), k.getHp() + 20));
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            p.raceModifierChange += 0.5f;
            p.setHp(Math.min(p.getMaxHP(), p.getHp() + 30));
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() > 0){
            w.raceModifierChange += 0.3f;
            w.setHp(Math.min(w.getMaxHP(), w.getHp() + 50));
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
        }
    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            r.raceModifierChange += 0.4f;
            r.setHp(Math.min(r.getMaxHP(), r.getHp() + 40));
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
        }
    }


}
