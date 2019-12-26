package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class DraculaVisitor extends Visitor {
    DraculaVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "hit";
        this.name = "Dracula";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() > 0){
            k.raceModifierChange += -0.2f;
            k.setHp(Math.max(0, k.getHp() - 60));
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            if(k.getHp() == 0){
                Visitor.magician.updateAngelKilled(k, k.id, fileWriter);
            }
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            p.raceModifierChange += -0.3f;
            p.setHp(Math.max(0, p.getHp() - 40));
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            if(p.getHp() == 0){
                Visitor.magician.updateAngelKilled(p, p.id, fileWriter);
            }
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() > 0){
            w.raceModifierChange += -0.4f;
            w.setHp(Math.max(w.getHp() - 20, 0));
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            if(w.getHp() == 0){
                Visitor.magician.updateAngelKilled(w, w.id, fileWriter);
            }
        }

    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            r.raceModifierChange += -0.1f;
            r.setHp(Math.max(r.getHp() - 35, 0));
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            if(r.getHp() == 0){
                Visitor.magician.updateAngelKilled(r, r.id, fileWriter);
            }
        }
    }

}
