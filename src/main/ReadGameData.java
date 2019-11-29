package main;


import fileio.implementations.FileReader;
import heroes.Hero;
import heroes.HeroFactory;
import java.io.IOException;
import java.util.ArrayList;

public class ReadGameData {
    String filename;
    int columns, rows, rounds, players;

    LandMap map;
    ArrayList<Hero> heroes = new ArrayList<>();
    char[][] movesMat;
    ReadGameData(String f){
        filename = f;
    }
    public void readData() throws IOException {

        FileReader fileReader = new FileReader(filename);

        rows = fileReader.nextInt();
        columns = fileReader.nextInt();

        ArrayList<String> mapContent = new ArrayList<>();
        for (int i = 0; i < rows; i++){
            mapContent.add(fileReader.nextWord());
        }
        map = LandMap.getInstance(mapContent);

        players = fileReader.nextInt();

        String currentType;
        HeroFactory heroFactory = new HeroFactory();
        int x, y;
        for(int i = 0; i < players; i++){
            currentType = fileReader.nextWord();
            x = fileReader.nextInt();
            y = fileReader.nextInt();
            heroes.add(heroFactory.makeNewHero(currentType, x, y));
        }

        rounds = fileReader.nextInt();
        movesMat = new char[rounds][players];
        for(int i = 0; i < rounds; i++){
            movesMat[i] = fileReader.nextWord().toCharArray();
        }
    }
}
