package Controller;

import Domain.ToyAbsentException;
import Domain.ToyList;
import Domain.Toys;
import Service.Logger;
import Service.Lottery;

import java.io.IOException;
import java.util.Scanner;

public class ControllerClass {
    private ToyList toyList;
    private Logger logger;

    public ControllerClass(ToyList toyList, Logger logger) {
        this.toyList = toyList;
        this.logger = logger;
    }
    Scanner scanner = new Scanner(System.in);
    private Lottery lottery = new Lottery();

    public void run() throws ToyAbsentException, IOException {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            System.out.print("Выберите команду(add|delete|list|change|lottery}exit):");
            String command = scanner.nextLine();
            com = Commands.valueOf(command.toUpperCase());
            switch (com) {
                case ADD:
                    toyList.addToy(toyList.createToy());
                    break;
                case DELETE:
                    System.out.print("Введите индекс игрушки, которую хотите удалить.");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    toyList.removeToy(deleteId);
                    break;
                case LIST:
                    toyList.printToysList();
                    break;
                case CHANGE:
                    System.out.print("Введите индекс игрушки, вес которой хотите изменить.");
                    int changeId = scanner.nextInt();
                    scanner.nextLine();
                    toyList.changeWeight(toyList, changeId);
                    break;
                case LOTTERY:
                    lottery.startLottery(toyList, logger);
                    break;
                case EXIT:
                    getNewIteration = false;
                    break;
                default:
                    System.out.println("Неверная команда");

            }
            }

    }


}
