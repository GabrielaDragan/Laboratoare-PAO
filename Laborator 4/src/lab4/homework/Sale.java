package lab4.homework;

public class Sale {

    private int tva = 20;
    private double total;
    private Article[] articles;
    private int currentNo;

    public Sale(int noOfArticles){
        this.articles = new Article[noOfArticles];
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(int currentNo) {
        this.currentNo = currentNo;
    }

    public void addArticles(String name, double price, int quantity){
        if(this.currentNo < this.articles.length){
            this.articles[currentNo++] = new Article(name, price, quantity);
        }
    }

    public double computeTotal(){
        for(int i = 0; i < this.articles.length; i++){
            this.total += this.articles[i].computePrice();
        }
        return total + (total * tva / 100);
    }
}
