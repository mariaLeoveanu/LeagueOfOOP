package strategy;

import heroes.*;

public interface Strategy {
    void applyStrategy(Knight knight);
    void applyStrategy(Pyromancer pyromancer);
    void applyStrategy(Rogue rogue);
    void applyStrategy(Wizard wizard);

}
