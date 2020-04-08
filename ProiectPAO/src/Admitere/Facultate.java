package Admitere;

public class Facultate {
    private String nume;
    private String adresa;
    private Specializare[] specializari;

    public Facultate() {
        this.adresa = "Strada Academiei, Bucuresti";
    }

    public Facultate(String nume, Specializare[] specializari) {
        this.nume = nume;
        this.adresa = "Strada Academiei, Bucuresti";
        this.specializari = specializari;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Specializare[] getSpecializari() {
        return specializari;
    }

    public void setSpecializari(Specializare[] specializari) {
        this.specializari = specializari;
    }
}
