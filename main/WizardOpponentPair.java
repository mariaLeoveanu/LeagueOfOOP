package main;

import heroes.Hero;

public final class WizardOpponentPair {
    private Hero wizard;
    private Hero opponent;

    public WizardOpponentPair(final Hero w, final Hero o) {
        this.setWizard(w);
        this.setOpponent(o);
    }

    public Hero getWizard() {
        return wizard;
    }

    public void setWizard(final Hero wizard) {
        this.wizard = wizard;
    }

    public Hero getOpponent() {
        return opponent;
    }

    public void setOpponent(final Hero opponent) {
        this.opponent = opponent;
    }
}
