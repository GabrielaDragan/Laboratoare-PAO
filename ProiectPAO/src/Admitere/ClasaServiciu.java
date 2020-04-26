package Admitere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Admitere.GestionareFisiere.citireCandidati;
import static Admitere.GestionareFisiere.citireSpecializari;

public class ClasaServiciu {
    protected List<FisaInscriere> fiseInscriere = new ArrayList<FisaInscriere>();
    protected Examen[] examene = new Examen[10];
    protected int numarExamene;

    public List<FisaInscriere> getFiseInscriere() {
        return fiseInscriere;
    }

    public void setFiseInscriere(List<FisaInscriere> fiseInscriere) {
        this.fiseInscriere = fiseInscriere;
    }

    public int getNumarFise() {
        return fiseInscriere.size();
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


    public void incarcareInitiala(){
        List<Candidat> candidatList = GestionareFisiere.getInstance().citireCandidati();
        Facultate facultate = new Facultate("Facultatea de Matematica si Informatica", citireSpecializari());
        for (Candidat candidat: candidatList){
            Set<Specializare> specializariCandidat = new HashSet<>();
            specializariCandidat.add(new Specializare("Informatica"));
            FisaInscriere fisaInscriere = new FisaInscriere(candidat, facultate, specializariCandidat );
            fiseInscriere.add(fisaInscriere);
        }
    }


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
        Set<Specializare> specializari = new HashSet<>();
        for(int i = 0; i < nr; i++){
            System.out.println("Denumirea specializarii (Informatica/Matematica/CTI): ");
            String den = scanner.next();
            Specializare spec = new Specializare(den);
            specializari.add(spec);
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
        fiseInscriere.add(new FisaInscriere(candidat, facultate, specializari));
    }

    //afisam candidati

    public void afiseazaFiseleDeInscriere(){
        for(FisaInscriere fisa: fiseInscriere){
            System.out.println("Nume: " + fisa.getCandidat().nume);
            System.out.println("Prenume: " + fisa.getCandidat().prenume);
            System.out.println("Varsta: " + fisa.getCandidat().varsta);
            System.out.println("Numele liceului absolvit: " + fisa.getCandidat().getLiceu().getNumeLiceu());
            System.out.println("Localitatea liceului: " + fisa.getCandidat().getLiceu().getLocalitatea());
            System.out.println("Profilul: " + fisa.getCandidat().getLiceu().getProfil());
            System.out.println("Media generala in liceu: " + fisa.getCandidat().getNote().getMedieLiceu());
            System.out.println("Media la Bacalaureat: " + fisa.getCandidat().getNote().getMedieBac());
            System.out.println("Numele facultatii la care te inscrii: " + fisa.getFacultate().getNume());
            System.out.println("Adresa facultatii la care te inscrii: " + fisa.getFacultate().getAdresa());
            int j = 1;
            for(Specializare specializare: fisa.getSpecializari()){
                System.out.println("Specializare " + j + ": " + specializare.getDenumire());
                j++;
            }
            System.out.println();
        }
    }

    //stergeFisaInscriere: sterge fisa de pe pozitia i
    public void stergeFisaInscriere(int i){
        this.fiseInscriere.remove(i);
    }
    //calculTaxa: calculeaza taxa de inscriere

    public int calculTaxa(int i){
        if(this.fiseInscriere.get(i).getSpecializari().size() == 1) {
            this.fiseInscriere.get(i).setTaxa(100);
            return 100;
        }
        else if(this.fiseInscriere.get(i).getSpecializari().size() == 2) {
            this.fiseInscriere.get(i).setTaxa(150);
            return 150;
        }
        this.fiseInscriere.get(i).setTaxa(200);
        return 200;
    }

    //verifica daca un cadidat este admis la buget pentru o specializare data
    public boolean admisBuget(int i, Specializare spec){
        return this.fiseInscriere.get(i).getNotaAdmitere() >= spec.getNotaMinBuget();
    }

    //verifica daca un cadidat este admis la taxa pentru o specializare data
    public boolean admisTaxa(int i, Specializare spec){
        return this.fiseInscriere.get(i).getNotaAdmitere() < spec.getNotaMinBuget() &&
                this.fiseInscriere.get(i).getNotaAdmitere() >= spec.getNotaMinTaxa();
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
        for(int i = 0; i < fiseInscriere.size(); i++){
            //System.out.println("Numar fisa curent: " + i);
            //System.out.println("Numar specializari: " + fiseInscriere[i].getSpecializari().length);
            for(Specializare specializare1: fiseInscriere.get(i).getSpecializari()){
                //System.out.println("Specializare curenta: " + fiseInscriere[i].getSpecializari()[j].getDenumire());
                String spec1 = specializare1.getDenumire();
                //System.out.println("Compar " + fiseInscriere[i].getSpecializari()[j].getDenumire() + " si " + spec);
                if(spec1.equals(spec)){
                    //System.out.println("Iau din: " + fiseInscriere[i].getCandidat().getNume());
                    //System.out.println("Creez: " + candidati[nrCandidati].getNume());
                    candidati[nrCandidati] = new Candidat(fiseInscriere.get(i).getCandidat().getNume(),
                            fiseInscriere.get(i).getCandidat().getPrenume(),
                            fiseInscriere.get(i).getCandidat().getVarsta(),
                            fiseInscriere.get(i).getCandidat().getLiceu(),
                            fiseInscriere.get(i).getCandidat().getNote());
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
        if (this.getNumarExamene() == 0) System.out.println("Nu exista nici un examen planificat in acest moment. \nDaca doriti sa adaugati un examen apasati tasta 5. ");
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
        if (this.getNumarExamene() == 0) System.out.println("Nu exista examene pentru care sa se realizeze impartirea in sali.");
        else {
            System.out.println("Pentru care examen doriti sa faceti impartirea pe sali ? ");

            int i;

            for (i = 0; i < this.getNumarExamene(); i++) {
                System.out.println(i + "." + this.examene[i].getSpecializare().getDenumire());
            }
            i = scanner.nextInt();
            int nr = this.examene[i].getNumarCandidati();
            int sali = 0;
            while (nr != 0) {
                if (this.examene[i].getSaliExamen()[sali].getLocuri() < nr) {
                    System.out.println("In sala " + this.examene[i].getSaliExamen()[sali].getNume() + " vor fi "
                            + this.examene[i].getSaliExamen()[sali].getLocuri() + " candidati.");
                    nr -= this.examene[i].getSaliExamen()[sali].getLocuri();
                    sali++;
                } else {
                    System.out.println("In sala " + this.examene[i].getSaliExamen()[sali].getNume() + " vor fi " + nr + " candidati.");
                    nr = 0;
                    sali++;
                }
            }
            return sali;
        }
        return 0;
    }

    //supraveghetoriNecesari in Examen -> calculeaza cati supraveghetori sunt necesari in functie de cate sali are un examen
}
