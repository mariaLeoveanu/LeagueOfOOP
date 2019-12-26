package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class XPAngelVisitor extends Visitor{
    XPAngelVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "helped";
        this.name = "XPAngel";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() > 0){
            k.setXp(k.getXp() + 45);
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            k.tryLevelUp(fileWriter);
        }

    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() > 0){
            p.setXp(p.getXp() + 50);
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            p.tryLevelUp(fileWriter);
        }

    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() > 0){
            w.setXp(w.getXp() + 60);
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            w.tryLevelUp(fileWriter);
        }

    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() > 0){
            r.setXp(r.getXp() + 40);
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            r.tryLevelUp(fileWriter);
        }

    }


}
