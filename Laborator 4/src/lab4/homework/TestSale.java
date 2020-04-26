package lab4.homework;

public class TestSale {
    public static void main(String[] args) {

        Sale sale = new Sale(2);
        sale.addArticles("mouse", 120, 1);
        sale.addArticles("mousePad", 23, 2);
        System.out.println(sale.computeTotal());
    }
}
