package Service;

import Domain.Toys;

import java.io.IOException;
import java.io.FileWriter;

public class Logger {
    String fileName;
    public Logger(String baseFileName) {
        this.fileName = baseFileName + ".txt";
    }
    public void AddWinnerToys(Toys toy) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(toy + "\n");
        }

    }
}
