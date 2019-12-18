package main;

import fileio.implementations.FileWriter;
import java.io.IOException;

public final class Main {
    private Main() { }

    public static void main(final String[] args) throws IOException {
        ReadGameData readGameData = new ReadGameData(args[0]);
        PrintGameData printGameData = new PrintGameData();
        FileWriter printData = new FileWriter(args[1]);
        GameProcess gameProcess = new GameProcess(readGameData);

        readGameData.readData();

        gameProcess.startGame();

        printGameData.printData(readGameData.getHeroes(), printData);

    }
}
