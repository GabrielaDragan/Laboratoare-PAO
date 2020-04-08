package Admitere;

public class SalaExamen {
    private String nume;
    private int locuri;
    private int etaj;

    public SalaExamen() {
    }

    public SalaExamen(String nume, int locuri, int etaj) {
        this.nume = nume;
        this.locuri = locuri;
        this.etaj = etaj;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getLocuri() {
        return locuri;
    }

    public void setLocuri(int locuri) {
        this.locuri = locuri;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public boolean incape(int x){
        if(x > this.locuri) return false;
        return true;
    }
}
