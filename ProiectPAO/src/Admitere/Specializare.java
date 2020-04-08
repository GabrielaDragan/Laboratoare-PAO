package Admitere;

public class Specializare {
    protected String denumire;
    protected int locuri;
    protected float notaMinBuget;
    protected float notaMinTaxa;
    protected int taxa;

    public Specializare() {
    }

    public Specializare(String denumire) {
        this.denumire = denumire;
        if(this.denumire.equals("Informatica")){
            Informatica info = new Informatica();
            this.locuri = info.getLocuri();
            this.notaMinBuget = info.getNotaMinBuget();
            this.notaMinTaxa = info.getNotaMinTaxa();
            this.taxa = info.getTaxa();
        }
        if(this.denumire.equals("Matematica")){
            Matematica mate = new Matematica();
            this.locuri = mate.getLocuri();
            this.notaMinBuget = mate.getNotaMinBuget();
            this.notaMinTaxa = mate.getNotaMinTaxa();
            this.taxa = mate.getTaxa();
        }
        if(this.denumire.equals("CTI")){
            CTI cti = new CTI();
            this.locuri = cti.getLocuri();
            this.notaMinBuget = cti.getNotaMinBuget();
            this.notaMinTaxa = cti.getNotaMinTaxa();
            this.taxa = cti.getTaxa();
        }
    }

    public Specializare(String denumire, int locuri, float notaMinBuget, float notaMinTaxa, int taxa) {
        this.denumire = denumire;
        this.locuri = locuri;
        this.notaMinBuget = notaMinBuget;
        this.notaMinTaxa = notaMinTaxa;
        this.taxa = taxa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    public float getNotaMinBuget() {
        return notaMinBuget;
    }

    public void setNotaMinBuget(float notaMinBuget) {
        this.notaMinBuget = notaMinBuget;
    }

    public float getNotaMinTaxa() {
        return notaMinTaxa;
    }

    public void setNotaMinTaxa(float notaMinTaxa) {
        this.notaMinTaxa = notaMinTaxa;
    }

    public int getTaxa() {
        return taxa;
    }

    public void setTaxa(int taxa) {
        this.taxa = taxa;
    }
}
