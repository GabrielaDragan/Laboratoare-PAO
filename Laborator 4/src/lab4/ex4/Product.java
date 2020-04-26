package lab4.ex4;

public class Product {
    private String name;
    private double unitPrice;
    private double sellingPrice;

    public Product(String name, double unitPrice, double sellingPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
