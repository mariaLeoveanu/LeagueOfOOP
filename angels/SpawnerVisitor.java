package angels;

import fileio.implementations.FileWriter;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.io.IOException;

public class SpawnerVisitor extends Visitor {
    SpawnerVisitor(int x, int y) throws IOException {
        super(x, y);
        this.actionType = "helped";
        this.name = "Spawner";
    }

    @Override
    public void apply(Knight k, FileWriter fileWriter) throws IOException {
        if(k.getHp() <= 0){
            k.setHp(200);
            k.setXp(0);
            k.setLevel(0);
            Visitor.magician.updateAction(this, k, k.id, fileWriter);
            Visitor.magician.updateRespawn(k);
        }
    }

    @Override
    public void apply(Pyromancer p, FileWriter fileWriter) throws IOException {
        if(p.getHp() <= 0){
            p.setHp(150);
            p.setXp(0);
            p.setLevel(0);
            Visitor.magician.updateAction(this, p, p.id, fileWriter);
            Visitor.magician.updateRespawn(p);
        }
    }

    @Override
    public void apply(Wizard w, FileWriter fileWriter) throws IOException {
        if(w.getHp() <= 0){
            w.setHp(120);
            w.setXp(0);
            w.setLevel(0);
            Visitor.magician.updateAction(this, w, w.id, fileWriter);
            Visitor.magician.updateRespawn(w);
        }
    }

    @Override
    public void apply(Rogue r, FileWriter fileWriter) throws IOException {
        if(r.getHp() <= 0){
            r.setHp(180);
            r.setXp(0);
            r.setLevel(0);
            Visitor.magician.updateAction(this, r, r.id, fileWriter);
            Visitor.magician.updateRespawn(r);
        }
    }


}
