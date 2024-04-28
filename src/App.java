import Controller.ControllerClass;
import Domain.ToyAbsentException;
import Domain.ToyList;
import Service.Logger;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ToyAbsentException {
        Logger logger = new Logger("winner_toys.txt");
        ToyList toyList = new ToyList();
        ControllerClass program = new ControllerClass(toyList, logger);
        program.run();

    }
}

