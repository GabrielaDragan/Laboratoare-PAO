package Admitere;

public class Note {
    private float medieBac;
    private float medieLiceu;
    private float notaExamen;

    public Note(float medieBac, float medieLiceu) {
        this.medieBac = medieBac;
        this.medieLiceu = medieLiceu;
        this.notaExamen = 0f;
    }

    public float getMedieBac() {
        return medieBac;
    }

    public void setMedieBac(float medieBac) {
        this.medieBac = medieBac;
    }

    public float getMedieLiceu() {
        return medieLiceu;
    }

    public void setMedieLiceu(float medieLiceu) {
        this.medieLiceu = medieLiceu;
    }

    public float getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(float notaExamen) {
        this.notaExamen = notaExamen;
    }
}
