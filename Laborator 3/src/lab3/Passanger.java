package lab3;

public class Passanger {
    private int freeBags;
    private int checkedBags;
    private char flightClass;

    public Passanger(){
    }

    public Passanger(int freeBags){
        this.freeBags = freeBags;
    }

    public Passanger(char flightClass){
        this.flightClass = flightClass;
    }

    public Passanger(int freeBags, int checkedBags){
        this.freeBags = freeBags;
        this.checkedBags = checkedBags;
    }

    public int getFreeBags() {
        return freeBags;
    }

    public void setFreeBags(int freeBags) {
        this.freeBags = freeBags;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public char getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(char flightClass) {
        this.flightClass = flightClass;
    }
}
