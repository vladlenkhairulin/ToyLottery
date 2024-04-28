package Service;

import Domain.ToyList;
import Domain.Toys;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery {


    public void startLottery(ToyList toys, Logger logger) throws IOException {
        if (toys.getSize() < 2) {
            System.out.print("Добавьте 2 или более игрушек в список");
        } else {
            List<Double> weightProbabilities = new ArrayList<>();
            for (Toys toy : toys.getToys()) {
                weightProbabilities.add(toy.getWeight() / 100);
            }
            int chosenIndex = WeightedRandom.chooseRandomIndex(weightProbabilities);

            Toys chosenToy = toys.getToys().remove(chosenIndex);
            System.out.print("В лотерее выиграла " + chosenToy);
            logger.AddWinnerToys(chosenToy);
        }
    }
}
