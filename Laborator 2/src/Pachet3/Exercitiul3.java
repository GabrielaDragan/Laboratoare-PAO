package Pachet3;

public class Exercitiul3 {
    public static void main(String[] args) {
        Room r1 = new Room();
        r1.setNumber("12A");
        r1.setType("normal");
        r1.setFloor(3);

        Room r2 = new Room();
        r2.setNumber("12B");
        r2.setType("tech");
        r2.setFloor(7);

        System.out.println(r1.getNumber() + " " + r1.getType() + " " + r1.getFloor());
        System.out.println(r2.getNumber() + " " + r2.getType() + " " + r2.getFloor());
    }
}
