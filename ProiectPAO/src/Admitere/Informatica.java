package Admitere;

public class Informatica extends Specializare {

    protected int locuri;
    protected float notaMinBuget;
    protected float notaMinTaxa;
    protected int taxa;

    public Informatica() {
        super.denumire = "Informatica";
        this.locuri = 220;
        this.notaMinBuget = 8.5f;
        this.notaMinTaxa = 7.3f;
        this.taxa = 4000;
    }

    @Override
    public int getLocuri() {
        return locuri;
    }

    @Override
    public float getNotaMinBuget() {
        return notaMinBuget;
    }

    @Override
    public float getNotaMinTaxa() {
        return notaMinTaxa;
    }

    @Override
    public int getTaxa() {
        return taxa;
    }

}
