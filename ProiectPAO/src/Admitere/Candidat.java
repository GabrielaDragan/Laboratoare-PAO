package Admitere;

import java.util.Random;

public class Candidat {
    protected String nume;
    protected String prenume;
    protected static int id;
    protected int varsta = 0;
    protected Liceu liceu;
    protected Note note;

    public Candidat(){
    }

    public Candidat(String nume, String prenume, int varsta, Liceu liceu, Note note) {
        this.nume = nume;
        this.prenume = prenume;
        this.id ++ ;
        this.varsta = varsta;
        this.liceu = liceu;
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public Liceu getLiceu() {
        return liceu;
    }

    public void setLiceu(Liceu liceu) {
        this.liceu = liceu;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setNotaExamen(){
        float nota = new Random().nextInt(10);
        this.note.setNotaExamen(nota);
    }

    //calculNotaAdmitere -> genereaza o nota random pt candidatul care o apeleaza
    public float calculNotaAdmitere(Note note){
        this.setNotaExamen();
        float notaAdmitere = note.getMedieBac() * 0.3f + note.getNotaExamen() * 0.7f;
        return notaAdmitere;
    }
}
