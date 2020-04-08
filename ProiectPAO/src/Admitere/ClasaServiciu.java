package Admitere;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ClasaServiciu {
    protected FisaInscriere[] fiseInscriere = new FisaInscriere[1000];
    protected int numarFise;
    protected Examen[] examene = new Examen[10];
    protected int numarExamene;

    public FisaInscriere[] getFiseInscriere() {
        return fiseInscriere;
    }

    public void setFiseInscriere(FisaInscriere[] fiseInscriere) {
        this.fiseInscriere = fiseInscriere;
    }

    public int getNumarFise() {
        return numarFise;
    }

    public void setNumarFise(int numarFise) {
        this.numarFise = numarFise;
    }

    public Examen[] getExamene() {
        return examene;
    }

    public void setExamene(Examen[] examene) {
        this.examene = examene;
    }

    public int getNumarExamene() {
        return numarExamene;
    }

    public void setNumarExamene(int numarExamene) {
        this.numarExamene = numarExamene;
    }

    Scanner scanner = new Scanner(System.in);


    //adaugaCandidat: adaugam un candidat nou de la tastatura
    public void inscriereCandidat(){
        //Datele candidatului
        System.out.println("Nume: ");
        String nume = scanner.next();
        System.out.println("Prenume: ");
        String prenume = scanner.next();
        System.out.println("Varsta: ");
        int varsta = scanner.nextInt();
        //Datele liceului
        System.out.println("Numele liceului absolvit: ");
        String numel = scanner.next();
        System.out.println("Localitatea: ");
        String localitate = scanner.next();
        System.out.println("Profilul: ");
        String profil = scanner.next();
        System.out.println("Media generala in liceu: ");
        float nota = scanner.nextFloat();
        System.out.println("Media la Bacalaureat: ");
        float notabac = scanner.nextFloat();
        //Datele facultatii
        System.out.println("Numele facultatii: ");
        String numef = scanner.next();
        //Specializarile facultatii
        System.out.println("Numarul de specializari la care aplici: ");
        int nr = scanner.nextInt();
        Specializare []specializari = new Specializare[nr];
        for(int i = 0; i < nr; i++){
            System.out.println("Denumirea specializarii (Informatica/Matematica/CTI): ");
            String den = scanner.next();
            //Specializare spec = new Specializare(den);
            //System.out.println(spec.getDenumire() + ' ' + spec.getLocuri());
            specializari[i] = new Specializare(den);
            //System.out.println(specializari[i].getDenumire() + ' ' + specializari[i].getLocuri());
        }
        //Creez obiectele necesare pentru o fisa de inscriere
        Liceu liceu = new Liceu(localitate, numel, profil);
        Note note = new Note(notabac, nota);
        Candidat candidat = new Candidat(nume, prenume, varsta, liceu, note);
        Specializare []toateSpec = new Specializare[3];
        toateSpec[0] = new Specializare("Informatica");
        toateSpec[1] = new Specializare("Matematica");
        toateSpec[2] = new Specializare("CTI");
        Facultate facultate = new Facultate(numef, toateSpec);
        fiseInscriere[this.numarFise] = new FisaInscriere(candidat, facultate, specializari);
        this.numarFise++;
    }

    //afisam candidati

    public void afiseazaFiseleDeInscriere(){
        for(int i = 0; i < this.numarFise; i++){
            System.out.println("Nume: " + fiseInscriere[i].getCandidat().nume);
            System.out.println("Prenume: " + fiseInscriere[i].getCandidat().prenume);
            System.out.println("Varsta: " + fiseInscriere[i].getCandidat().varsta);
            System.out.println("Numele liceului absolvit: " + fiseInscriere[i].getCandidat().getLiceu().getNumeLiceu());
            System.out.println("Localitatea liceului: " + fiseInscriere[i].getCandidat().getLiceu().getLocalitatea());
            System.out.println("Profilul: " + fiseInscriere[i].getCandidat().getLiceu().getProfil());
            System.out.println("Media generala in liceu: " + fiseInscriere[i].getCandidat().getNote().getMedieLiceu());
            System.out.println("Media la Bacalaureat: " + fiseInscriere[i].getCandidat().getNote().getMedieBac());
            System.out.println("Numele facultatii la care te inscrii: " + fiseInscriere[i].getFacultate().getNume());
            System.out.println("Adresa facultatii la care te inscrii: " + fiseInscriere[i].getFacultate().getAdresa());
            for(int j = 0; j < fiseInscriere[i].getSpecializari().length; j++){
                System.out.println("Specializare " + (j + 1) + ": " + fiseInscriere[i].getSpecializari()[j].getDenumire());
            }
            System.out.println();
        }
    }

    //stergeFisaInscriere: sterge fisa de pe pozitia i
    public void stergeFisaInscriere(int i){
        if(this.getNumarFise() == 1){
            this.fiseInscriere[0] = null;
        }
        if(i == this.getNumarFise() - 1){
            //System.out.println("SUNT IN PRIMUL IF");
            this.fiseInscriere[this.getNumarFise()] = null;
        }
        if (i !=  this.getNumarFise() - 1 && this.getNumarFise() != 1) {
            //System.out.println("SUNT IN AL DOILEA IF");
            for (int j = i; j < this.getNumarFise() - 1; j++){
                this.fiseInscriere[j].setCandidat(this.fiseInscriere[j + 1].getCandidat());
                this.fiseInscriere[j].setFacultate(this.fiseInscriere[j + 1].getFacultate());
                this.fiseInscriere[j].setSpecializari(this.fiseInscriere[j + 1].getSpecializari());
                this.fiseInscriere[j].setTaxa(this.fiseInscriere[j + 1].getTaxa());
            }
            this.fiseInscriere[this.getNumarFise()] = null;
        }
        this.setNumarFise(this.getNumarFise() - 1);
    }
    //calculTaxa: calculeaza taxa de inscriere

    public int calculTaxa(int i){
        if(this.fiseInscriere[i].getSpecializari().length == 1) {
            this.fiseInscriere[i].setTaxa(100);
            return 100;
        }
        else if(this.fiseInscriere[i].getSpecializari().length == 2) {
            this.fiseInscriere[i].setTaxa(150);
            return 150;
        }
        this.fiseInscriere[i].setTaxa(200);
        return 200;
    }

    //verifica daca un cadidat este admis la buget pentru o specializare data
    public boolean admisBuget(int i, Specializare spec){
        return this.fiseInscriere[i].getNotaAdmitere() >= spec.getNotaMinBuget();
    }

    //verifica daca un cadidat este admis la taxa pentru o specializare data
    public boolean admisTaxa(int i, Specializare spec){
        return this.fiseInscriere[i].getNotaAdmitere() < spec.getNotaMinBuget() &&
                this.fiseInscriere[i].getNotaAdmitere() >= spec.getNotaMinTaxa();
    }

    //verifica daca un cadidat este respins pentru o specializare data
    public boolean respins(int i, Specializare spec){
        return !(admisBuget(i, spec) || admisTaxa(i, spec));
    }

    public void adaugaExamen(){
        //Specializarea la care se da examenul
        System.out.println("Pentru ce specializare este examenul? (Informatica / Matematica / CTI)");
        String spec = scanner.next();
        Specializare specializare = new Specializare(spec);

        //Supraveghetori la examen
        System.out.println("Cati supraveghetori vor fi la examen? ");
        int x = scanner.nextInt();
        String nume, prenume;
        Supraveghetor []supraveghetori = new Supraveghetor[10];
        for(int i = 0; i < x; i++){
            System.out.println("Nume si prenume supraveghetor " + (i+1) + ":");
            nume = scanner.next();
            prenume = scanner.next();
            supraveghetori[i] = new Supraveghetor(nume, prenume);
        }

        //Salile disponibile in facultate
        SalaExamen sala0 = new SalaExamen("Haret", 60, 0);
        SalaExamen sala1 = new SalaExamen("Stoilow", 50, 1);
        SalaExamen sala2 = new SalaExamen("Pompei", 50, 2);
        SalaExamen sala3 = new SalaExamen("Titeica", 60, 3);
        SalaExamen []saliExamen = {sala1, sala2, sala3, sala0};

        Candidat []candidati = new Candidat[500];
        int nrCandidati = 0;
        for(int i = 0; i < numarFise; i++){
            //System.out.println("Numar fisa curent: " + i);
            //System.out.println("Numar specializari: " + fiseInscriere[i].getSpecializari().length);
            for(int j = 0; j < fiseInscriere[i].getSpecializari().length; j++){
                //System.out.println("Specializare curenta: " + fiseInscriere[i].getSpecializari()[j].getDenumire());
                String spec1 = fiseInscriere[i].getSpecializari()[j].getDenumire();
                //System.out.println("Compar " + fiseInscriere[i].getSpecializari()[j].getDenumire() + " si " + spec);
                if(spec1.equals(spec)){
                    //System.out.println("Iau din: " + fiseInscriere[i].getCandidat().getNume());
                    //System.out.println("Creez: " + candidati[nrCandidati].getNume());
                    candidati[nrCandidati] = new Candidat(fiseInscriere[i].getCandidat().getNume(),
                            fiseInscriere[i].getCandidat().getPrenume(),
                            fiseInscriere[i].getCandidat().getVarsta(),
                            fiseInscriere[i].getCandidat().getLiceu(),
                            fiseInscriere[i].getCandidat().getNote());
                    //System.out.println(candidati[nrCandidati].getPrenume());
                    nrCandidati ++;
                }
            }
        }

        this.examene[numarExamene] = new Examen(specializare, candidati, supraveghetori, saliExamen, nrCandidati, x);
        this.numarExamene++;
    }

    public void afiseazaExamene(){
        //System.out.println("Avem " + this.getNumarExamene() + " examene: ");
        for(int i = 0; i < this.getNumarExamene(); i++){
            System.out.println("Examen pentru specializarea " + this.examene[i].getSpecializare().getDenumire());
            System.out.println();
            System.out.println("Supraveghetori: ");
            for(int j = 0; j < this.examene[i].getNumarSupraveghetori(); j++){
                System.out.println(this.examene[i].getSupraveghetori()[j].getNume() + ' ' + this.examene[i].getSupraveghetori()[j].getPrenume());
            }
            System.out.println();
            System.out.println("Participantii la examen: ");
            for(int j = 0; j < this.examene[i].getNumarCandidati(); j++){
                System.out.println(this.examene[i].getCandidati()[j].getNume() + ' ' + this.examene[i].getCandidati()[j].getPrenume());
            }
            System.out.println();
        }
    }

    //sterge examenul de pe pozitia i
    public void stergeExamen(int i){
        if(this.getNumarExamene() == 1){
            this.examene[0] = null;
        }
        if(i == this.getNumarExamene() - 1){
            //System.out.println("SUNT IN PRIMUL IF");
            this.examene[this.getNumarExamene()] = null;
        }
        if (i !=  this.getNumarExamene() - 1 && this.getNumarExamene() != 1) {
            //System.out.println("SUNT IN AL DOILEA IF");
            for (int j = i; j < this.getNumarExamene() - 1; j++){
                this.examene[j].setSpecializare(this.examene[j + 1].getSpecializare());
                this.examene[j].setCandidati(this.examene[j + 1].getCandidati());
                this.examene[j].setSaliExamen(this.examene[j + 1].getSaliExamen());
                this.examene[j].setSupraveghetori(this.examene[j + 1].getSupraveghetori());
                this.examene[j].setNumarCandidati(this.examene[j + 1].getNumarCandidati());
                this.examene[j].setNumarCandidati(this.examene[j + 1].getNumarCandidati());
            }
            this.examene[this.getNumarExamene()] = null;
        }
        this.setNumarExamene(this.getNumarExamene() - 1);
    }

    //impartireInSali -> se atribuie fiecarei sali numarul maxim de candidati pana cand acestia sunt distribuiti toti
    public int impartireInSali(){
        System.out.println("Pentru care examen doriti sa faceti impartirea pe sali ? ");
        int i;
        for(i = 0; i < this.getNumarExamene(); i++){
            System.out.println(i + "." + this.examene[i].getSpecializare().getDenumire());
        }
        i = scanner.nextInt();
        int nr = this.examene[i].getNumarCandidati();
        int sali = 0;
        while(nr != 0) {
            if (this.examene[i].getSaliExamen()[sali].getLocuri() < nr) {
                System.out.println("In sala " + this.examene[i].getSaliExamen()[sali].getNume() + " vor fi "
                        + this.examene[i].getSaliExamen()[sali].getLocuri() + " candidati.");
                nr -= this.examene[i].getSaliExamen()[sali].getLocuri();
                sali ++;
            } else {
                System.out.println("In sala " + this.examene[i].getSaliExamen()[sali].getNume() + " vor fi " + nr + " candidati.");
                nr = 0;
                sali++;
            }
        }
        return sali;
    }

    //supraveghetoriNecesari in Examen -> calculeaza cati supraveghetori sunt necesari in functie de cate sali are un examen
}
