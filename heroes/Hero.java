package heroes;

import angels.Visitor;
import fileio.implementations.FileWriter;
import main.Constants;
import main.Magician;
import main.OvertimeInfo;
import strategy.Strategy;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Hero {
    private int x;
    private int y;
    private int xp;
    private int hp;
    private int maxHP;
    // damageWoRaceModif stores the damage dealt to the wizard before race modifier was applied
    private int damageWoRaceModif;
    private int level;
    // stores the number of rounds for which the player is unable to move,
    // both for slam and paralysed abilities
    private int paralysed;
    private boolean wasAttackedThisRound;
    private char name;
    public String type;
    private OvertimeInfo otDmg;
    private int healthPerLevel;
    public float raceModifierChange;
    Strategy chosenStrategy;
    public int id;
    public int initialXP;
    public int opponent;
    public Hero heroKilledThisRound;

    Hero(final int x, final int y, int id) {
        setX(x);
        setY(y);
        setParalysed(0);
        setXp(0);
        setLevel(0);
        setWasAttackedThisRound(false);
        setDamageWoRaceModif(0);
        setOtDmg(new OvertimeInfo(0, 0));
        raceModifierChange = 0;
        this.id = id;
    }

    public final void checkOtDmg() {
        if (this.getHp() > 0 && getOtDmg().getNumRounds() > 0) {
            this.setHp(this.getHp() - getOtDmg().getDmgPerRound());
            getOtDmg().setNumRounds(getOtDmg().getNumRounds() - 1);

            if (this.getHp() < 0) {
                this.setHp(0);
            }
        }
    }

    public abstract void chooseStrategy();

    public final void move(final char c) {
        if (this.getHp() > 0 && getParalysed() <= 0) {
            switch (c) {
                case 'U':
                    this.setX(this.getX() - 1);
                    break;
                case 'D':
                    this.setX(this.getX() + 1);
                    break;
                case 'L':
                    this.setY(this.getY() - 1);
                    break;
                case 'R':
                    this.setY(this.getY() + 1);
                    break;
                case '_':
                    break;
                default:
                    break;
            }
        } else {
            // not move, decrease number of remaining rounds
            setParalysed(getParalysed() - 1);
        }
    }

    public final int checkForOpponents(final ArrayList<Hero> allPlayers, final int playerID) {
        // if the player was not attacked this round as is dead, it can't check for opponent
        if (this.getHp() <= 0 && !isWasAttackedThisRound()) {
            return -1;
        }
        for (int i = 0; i < allPlayers.size(); i++) {
            if (i != playerID
                    && this.getX() == allPlayers.get(i).getX()
                    && this.getY() == allPlayers.get(i).getY()
                    && allPlayers.get(i).getHp() > 0
                    && !allPlayers.get(i).isWasAttackedThisRound()) {
                return i;
            }
        }
        return -1;
    }

    public final void checkIfOpponentKilled(final Hero hero, FileWriter fileWriter) throws IOException {
        Magician magician = new Magician();
        if (hero.getHp() <= 0 && hero.isWasAttackedThisRound()) {
            this.heroKilledThisRound = hero;
            if(this.hp <= 0){
                return;
            }
            this.setXp(this.getXp() + Math.max(0,
                    Constants.XP_FORMULA_MINUEND
                            - (this.getLevel() - hero.getLevel()) * Constants.XP_FORMULA_MULTIPLIER));

        }else this.heroKilledThisRound = null;
    }

    public final void tryLevelUp(FileWriter fileWriter) throws IOException {
        if (this.getHp() <= 0) {
            return;
        }
        int previousLevel = this.getLevel();
        if (this.getXp() < Constants.BASE_XP) {
            this.setLevel(0);
        } else {
            this.setLevel((this.getXp() - Constants.BASE_XP) / Constants.XP_PER_LEVEL + 1);
            // if there actually was a level up, modify hp stats
            if (this.getLevel() != previousLevel) {
                this.setMaxHP(this.getMaxHP() + (this.getLevel() - previousLevel) * this.getHealthPerLevel());
                this.setHp(this.getMaxHP());
                if(this.getLevel() - previousLevel > 1){
                    for(int i = previousLevel + 1; i <= this.getLevel() - 1; i++){
                        fileWriter.writeWord(this.type + " " + this.id + " reached level " + i);
                        fileWriter.writeNewLine();
                    }
                }
                Visitor.magician.updateLevelUp(this,fileWriter);
            }
        }
    }

    public abstract void attack(Hero hero, char[][] map);
    public abstract void accept(Visitor v, FileWriter fileWriter) throws IOException;

    public final int getX() {
        return x;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(final int y) {
        this.y = y;
    }

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getHp() {
        return hp;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    public final int getMaxHP() {
        return maxHP;
    }

    public final void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }

    public final int getDamageWoRaceModif() {
        return damageWoRaceModif;
    }

    public final void setDamageWoRaceModif(final int damageWoRaceModif) {
        this.damageWoRaceModif = damageWoRaceModif;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getParalysed() {
        return paralysed;
    }

    public final void setParalysed(final int paralysed) {
        this.paralysed = paralysed;
    }

    public final boolean isWasAttackedThisRound() {
        return wasAttackedThisRound;
    }

    public final void setWasAttackedThisRound(final boolean wasAttackedThisRound) {
        this.wasAttackedThisRound = wasAttackedThisRound;
    }

    public final char getName() {
        return name;
    }

    public final void setName(final char name) {
        this.name = name;
    }

    public final OvertimeInfo getOtDmg() {
        return otDmg;
    }

    public final void setOtDmg(final OvertimeInfo otDmg) {
        this.otDmg = otDmg;
    }

    public final int getHealthPerLevel() {
        return healthPerLevel;
    }

    public final void setHealthPerLevel(final int healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
    }
}