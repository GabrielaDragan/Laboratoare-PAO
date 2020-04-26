package lab4.ex4;

public class Exemplu1 {
    public static void main(String[] args) {
        Sale sale = new Sale (2);
        sale.addProduct("mouse", 12.3, 23);
        sale.addProduct("mousePad", 13, 34);

        System.out.println(sale.computeTotal());
    }
}
