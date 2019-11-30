package main;


import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;

import java.io.IOException;
import java.util.ArrayList;

public final class ReadGameData {
    private String filename;
    private int columns;
    private int rows;
    private int rounds;
    private int players;

    private LandMap map;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private char[][] movesMat;

    ReadGameData(final String f) {
        setFilename(f);
    }

    public void readData() throws IOException {
        FileReader fileReader = new FileReader(getFilename());

        setRows(fileReader.nextInt());
        setColumns(fileReader.nextInt());

        ArrayList<String> mapContent = new ArrayList<>();
        for (int i = 0; i < getRows(); i++) {
            mapContent.add(fileReader.nextWord());
        }
        setMap(LandMap.getInstance(mapContent));

        setPlayers(fileReader.nextInt());

        String currentType;
        HeroFactory heroFactory = new HeroFactory();
        int x, y;
        for (int i = 0; i < getPlayers(); i++) {
            currentType = fileReader.nextWord();
            x = fileReader.nextInt();
            y = fileReader.nextInt();
            getHeroes().add(heroFactory.makeNewHero(currentType, x, y));
        }

        setRounds(fileReader.nextInt());
        setMovesMat(new char[getRounds()][getPlayers()]);
        for (int i = 0; i < getRounds(); i++) {
            getMovesMat()[i] = fileReader.nextWord().toCharArray();
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public void setColumns(final int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(final int rows) {
        this.rows = rows;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(final int rounds) {
        this.rounds = rounds;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(final int players) {
        this.players = players;
    }

    public LandMap getMap() {
        return map;
    }

    public void setMap(final LandMap map) {
        this.map = map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }


    public char[][] getMovesMat() {
        return movesMat;
    }

    public void setMovesMat(final char[][] movesMat) {
        this.movesMat = movesMat;
    }
}
