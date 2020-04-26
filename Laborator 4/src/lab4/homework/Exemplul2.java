package lab4.homework;

public class Exemplul2 {

    public static void main(String[] args) {
        //static polymorphism
        Product p1 = new Product();
        p1.setName("Flour");
        p1.setPrice(12.0);
        p1.setSellingPrice(23.3);

        System.out.println("Ten items = " + p1.computePrice(10));
        System.out.println("Ten items with 20% discount = " + p1.computePrice(10, 20));
    }
}
