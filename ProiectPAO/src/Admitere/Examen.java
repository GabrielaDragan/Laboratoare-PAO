package Admitere;
import java.util.Random;

public class Examen {
    private Specializare specializare;
    private Candidat[] candidati;
    private Supraveghetor[] supraveghetori;
    private int numarSupraveghetori;
    private SalaExamen[] saliExamen;
    private int numarCandidati;

    public Examen(Specializare specializare, Candidat[] candidati, Supraveghetor[] supraveghetori, SalaExamen[] saliExamen, int numarCandidati, int numarSupraveghetori) {
        this.specializare = specializare;
        this.candidati = candidati;
        this.supraveghetori = supraveghetori;
        this.saliExamen = saliExamen;
        this.numarCandidati = numarCandidati;
        this.numarSupraveghetori = numarSupraveghetori;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    public Candidat[] getCandidati() {
        return candidati;
    }

    public void setCandidati(Candidat[] candidati) {
        this.candidati = candidati;
    }

    public Supraveghetor[] getSupraveghetori() {
        return supraveghetori;
    }

    public void setSupraveghetori(Supraveghetor[] supraveghetori) {
        this.supraveghetori = supraveghetori;
    }

    public SalaExamen[] getSaliExamen() {
        return saliExamen;
    }

    public void setSaliExamen(SalaExamen[] saliExamen) {
        this.saliExamen = saliExamen;
    }

    public int getNumarCandidati() {
        return numarCandidati;
    }

    public void setNumarCandidati(int numarCandidati) {
        this.numarCandidati = numarCandidati;
    }

    public int getNumarSupraveghetori() {
        return numarSupraveghetori;
    }

    public void setNumarSupraveghetori(int numarSupraveghetori) {
        this.numarSupraveghetori = numarSupraveghetori;
    }


}
