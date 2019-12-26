package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class TheDoomerVisitor extends Visitor {
    TheDoomerVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "hit";
        this.name = "TheDoomer";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() > 0){
            k.setHp(0);
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            Visitor.magician.updateAngelKilled(k, k.id, fileWriter);
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            p.setHp(0);
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            Visitor.magician.updateAngelKilled(p, p.id, fileWriter);
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() > 0){
            w.setHp(0);
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            Visitor.magician.updateAngelKilled(w, w.id, fileWriter);
        }

    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            r.setHp(0);
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            Visitor.magician.updateAngelKilled(r, r.id, fileWriter);
        }

    }


}
