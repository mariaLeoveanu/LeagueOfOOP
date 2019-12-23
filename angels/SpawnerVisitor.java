package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SpawnerVisitor extends Visitor {
    SpawnerVisitor(int x, int y) {
        super(x, y);
        this.actionType = "helped";
        this.name = "Spawner";
    }

    @Override
    public void apply(Knight k) {
        if(k.getHp() <= 0){
            k.setHp(200);
            k.setXp(0);
            k.setLevel(0);
        }
    }

    @Override
    public void apply(Pyromancer p) {
        if(p.getHp() <= 0){
            p.setHp(150);
            p.setXp(0);
            p.setLevel(0);
        }
    }

    @Override
    public void apply(Wizard w) {
        if(w.getHp() <= 0){
            w.setHp(120);
            w.setXp(0);
            w.setLevel(0);
        }
    }

    @Override
    public void apply(Rogue r) {
        if(r.getHp() <= 0){
            r.setHp(180);
            r.setXp(0);
            r.setLevel(0);
        }
    }


}
