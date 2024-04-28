package Domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ToyList {
    private List<Toys> toys;
    private int size;
    public ToyList() {
        this.toys = new ArrayList<>();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
    public void addToy(Toys toy) {
        try {
            toys.add(toy);
            size++;
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении игрушки: " + e.getMessage());
        }
    }
    public void removeToy(int id) throws ToyAbsentException {
        try {
            for (int i = 0; i < toys.size(); i++) {
                if (toys.get(i).getId() == id) {
                    toys.remove(i);
                    size--;
                    return;
                }
            }
            throw new ToyAbsentException("Игрушка с номером " + id + " не найдена.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка при удалении игрушки: "  + e.getMessage());
        }
    }
    public void printToysList() {
        if (size == 0) {
            System.out.println("Список игрушек пуст.");
            return;
        }

        System.out.println("Список игрушек:");
        for (int i = 0; i < toys.size(); i++) {
            Toys toy = toys.get(i);
            System.out.println(i + 1 + ". " + toy);
            //System.out.print(toys.size());
        }
    }
    private Toys findToyById(ToyList toys, int id) {
        for (Toys toy : toys.getToys()) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }


    public Toys changeWeight(ToyList toys, int id) throws ToyAbsentException {
        final Scanner scanner = new Scanner(System.in);

        Toys toy = findToyById(toys, id);
        if (toy == null) {
            throw new ToyAbsentException("Игрушка с номером " + id + " не найдена.");
        }
        try {
            System.out.print("Введите новый вес игрушки (вес должен находиться в пределах от 1 до 100): ");
            double newWeight = Double.parseDouble(scanner.nextLine());
            if (newWeight < 1 || newWeight > 100) {
                System.out.println("Вес должен находиться в пределах от 1 до 100");
                return null;
            } else {
                toy.setWeight(newWeight);
                return toy;
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели некорректное значение веса");
            return null;
        }
    }
    public Toys createToy() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите ID игрушки: ");
            int id = scanner.nextInt();
            // нужно очистить буфер, так как после использования nextInt() там остался лишний символ перехода на новую строку.
            scanner.nextLine();

            System.out.print("Введите название игрушки: ");
            String name = scanner.nextLine();

            System.out.print("Введите вес игрушки: ");
            double weight = scanner.nextDouble();

            return new Toys(id, name, weight);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
            return null;
        }
    }



    public List<Toys> getToys() {
        return toys;
    }


}
