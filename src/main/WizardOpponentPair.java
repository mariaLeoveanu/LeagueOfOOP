package main;

import heroes.Hero;
import heroes.Wizard;

public class WizardOpponentPair {
    public Hero wizard;
    public Hero opponent;
    public WizardOpponentPair(Hero w, Hero o){
        this.wizard = w;
        this.opponent = o;
    }
}
