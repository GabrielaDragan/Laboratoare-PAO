package Admitere;

public class CTI extends Specializare {

    protected int locuri;
    protected float notaMinBuget;
    protected float notaMinTaxa;
    protected int taxa;


    public CTI() {
        super.denumire = "CTI";
        this.locuri = 100;
        this.notaMinBuget = 6.5f;
        this.notaMinTaxa = 5.5f;
        this.taxa = 4500;
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
