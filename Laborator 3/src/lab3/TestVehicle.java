package lab3;

public class TestVehicle {

    public static void main(String[] args) {

        Car c1 = new Car();
        System.out.println(c1.seats);
        System.out.println(c1.getDoors());

        Bus b1 = new Bus();
        System.out.println(b1.seats);
        System.out.println(b1.getDoors());

        Car c2 = new Bus();
        System.out.println(c2.seats);
        System.out.println(c2.getDoors());

        System.out.println(c2.getClass());
    }
}
