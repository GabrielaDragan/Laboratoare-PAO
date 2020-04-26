package lab4.ex1;

public class Produs {
    double price;

    public double computePrice(int noOfProducts){
        return this.price * noOfProducts;
    }
    public double computePrice(int noOfProducts, int discount){
        this.price = -(this.price * discount/100);
        return this.price * noOfProducts;
    }
}
