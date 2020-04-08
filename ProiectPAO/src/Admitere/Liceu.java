package Admitere;

public class Liceu {
    private String localitatea;
    private String numeLiceu;
    private String profil;

    public Liceu(String localitatea, String numeLiceu, String profil) {
        this.localitatea = localitatea;
        this.numeLiceu = numeLiceu;
        this.profil = profil;
    }

    public String getLocalitatea() {
        return localitatea;
    }

    public void setLocalitatea(String localitatea) {
        this.localitatea = localitatea;
    }

    public String getNumeLiceu() {
        return numeLiceu;
    }

    public void setNumeLiceu(String numeLiceu) {
        this.numeLiceu = numeLiceu;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
