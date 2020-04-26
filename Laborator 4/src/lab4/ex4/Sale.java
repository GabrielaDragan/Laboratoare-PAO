package lab4.ex4;

public class Sale {

    private Product[] products;
    private double totalPrice;
    private int currentNo;

    public Sale(int maxNoOfArticles){
        this.products = new Product[maxNoOfArticles];
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(int currentNo) {
        this.currentNo = currentNo;
    }

    public void addProduct(String name, double price, double sellingPrice){
        if(currentNo < this.products.length){
            this.products[currentNo++] = new Product(name, price, sellingPrice);
            System.out.println("The product was added");
        } else {
            System.out.println("The product cannot be added");
        }
    }

    public double computeTotal(){
        for (int i=0; i<this.products.length; i++){
            this.totalPrice += this.products[i].getSellingPrice();
        }
        return this.totalPrice;
    }
}
