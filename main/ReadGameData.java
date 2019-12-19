package main;


import angels.AngelFactory;
import angels.Visitor;
import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class ReadGameData {
    private String filename;
    private int columns;
    private int rows;
    private int rounds;
    private int players;

    private LandMap map;
    private ArrayList<Hero> heroes = new ArrayList<>();
    private char[][] movesMat;
    public ArrayList<ArrayList<Visitor>> angels = new ArrayList<>();

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
        AngelFactory angelFactory = new AngelFactory();
        for(int i = 0; i < rounds; i++){
            // read number of angels in current round
            int angelsThisRound = fileReader.nextInt();
            ArrayList<Visitor> roundAngels = new ArrayList<>();
            for (int j = 0; j < angelsThisRound; j++){
                // read each angel on current line
                String angel = fileReader.nextWord();
                ArrayList<String> contents = new ArrayList<>(Arrays.asList(angel.split(",")));
                roundAngels.add(angelFactory.getAngelVisitor(contents.get(0),
                        Integer.parseInt(contents.get(1)), Integer.parseInt(contents.get(2))));
            }
            //add list of angles in current round to total of angels
            angels.add(roundAngels);
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
