package lab4.ex3;

import java.util.Arrays;

public class Exemplul1 {
    public static void main(String[] args) {
        Profesor p1 = new Profesor("John", "Doe", 34, 7);
        Profesor p2 = new Profesor("John", "Rue", 54, 8);

        Profesor[] profesors = {p1, p2};

        Departament d1 = new Departament("IT", profesors);
    }

}
