package main;

public final class OvertimeInfo {
    private int numRounds;
    private int dmgPerRound;

    public OvertimeInfo(final int rounds, final int damage) {
        setNumRounds(rounds);
        setDmgPerRound(damage);
    }

    public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(final int numRounds) {
        this.numRounds = numRounds;
    }

    public int getDmgPerRound() {
        return dmgPerRound;
    }

    public void setDmgPerRound(final int dmgPerRound) {
        this.dmgPerRound = dmgPerRound;
    }
}
