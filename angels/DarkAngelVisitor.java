package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class DarkAngelVisitor extends Visitor {
    DarkAngelVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "hit";
        this.name = "DarkAngel";
    }

    //TODO: verific daca moare
    //TODO: inlocuiesc if(){..} cu Math.max(0, hp-delta)

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() > 0){
            k.setHp(k.getHp() - 40);
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            if(k.getHp() < 0){
                k.setHp(0);
            }
        }
    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            p.setHp(p.getHp() - 30);
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            if (p.getHp() < 0){
                p.setHp(0);
            }
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if (w.getHp() > 0){
            w.setHp(w.getHp() - 20);
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            if(w.getHp() < 0){
                w.setHp(0);
            }
        }

    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            r.setHp(r.getHp() - 10);
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            if(r.getHp() < 0){
                r.setHp(0);
            }
        }
    }


}
