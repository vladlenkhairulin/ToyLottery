package Domain;

import java.text.ParseException;
import java.util.Scanner;

public class Toys {
    int id;
    String name;
    double weight;

    public int getId() {
        return id;
    }

    public Toys(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getWeight() {
        return weight;
    }





    @Override
    public String toString() {
        return "Игрушка: " +
                "id = " + id +
                ", название = '" + name + '\'' +
                ", вес = " + weight +
                '.';
    }
}
