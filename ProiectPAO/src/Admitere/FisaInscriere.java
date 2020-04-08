package Admitere;

public class FisaInscriere{
    private Candidat candidat;
    private Facultate facultate;
    private Specializare[] specializari;
    private float notaAdmitere;
    //Taxa de inscriere pentru specializari (100 pt o specializare, 150 pt doua specializari, 200 pt trei specializari)
    private int taxa;

    public FisaInscriere() {
    }

    public FisaInscriere(Candidat candidat, Facultate facultate, Specializare[] specializari) {
        this.candidat = candidat;
        this.facultate = facultate;
        this.specializari = specializari;
        this.notaAdmitere = this.candidat.calculNotaAdmitere(this.candidat.getNote());
        this.taxa = 0;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public Specializare[] getSpecializari() {
        return specializari;
    }

    public void setSpecializari(Specializare[] specializari) {
        this.specializari = specializari;
    }

    public float getNotaAdmitere() { return notaAdmitere; }

    public void setNotaAdmitere(float notaAdmitere) { this.notaAdmitere = notaAdmitere; }

    public int getTaxa() {
        return taxa;
    }

    public void setTaxa(int taxa) {
        this.taxa = taxa;
    }

}
