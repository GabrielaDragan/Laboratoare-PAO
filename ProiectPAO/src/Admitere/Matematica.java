package Admitere;

public class Matematica extends Specializare {

    protected int locuri;
    protected float notaMinBuget;
    protected float notaMinTaxa;
    protected int taxa;

    public Matematica() {
        super.denumire = "Matematica";
        this.locuri = 150;
        this.notaMinBuget = 6.5f;
        this.notaMinTaxa = 6f;
        this.taxa = 3500;
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
