package Service;

import java.util.List;
import java.util.Random;

/**
 * этот метод принимает список весов игрушек и случайно генерирует число randomValue
 * в диапазоне от 0.0 до 0.99. Первый вес игрушки в этом списке, который будет больше
 * randomValue, считается "счастливчиком".
 */
public class WeightedRandom {
    public static int chooseRandomIndex(List<Double> weights) {

        Random random = new Random();
        int chosenIndex = 0;
        double randomValue = random.nextDouble();
        while (chosenIndex < weights.size() && randomValue > weights.get(chosenIndex)) {
            chosenIndex++;
        }
        return chosenIndex;
}
}
