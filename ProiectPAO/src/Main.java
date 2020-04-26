import Admitere.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void scriereInitiala() {
        ArrayList<String> noteScris = new ArrayList();
        noteScris.add("5.5,6.1");
        noteScris.add("7.4,3.2");
        GestionareFisiere.getInstance().writeBulkTextToFile(noteScris, "./input/Note.csv");

        ArrayList<String> liceeScris = new ArrayList();
        liceeScris.add("Buzau,Liceu scris cu fisier,Uman");
        liceeScris.add("Cluj,Liceu din Cluj, Uman");
        GestionareFisiere.getInstance().writeBulkTextToFile(liceeScris, "./input/Licee.csv");

        ArrayList<String> candidatiScris = new ArrayList();
        candidatiScris.add("Popescu,Ion,25");
        candidatiScris.add("Ionescu,Pop,25");
        GestionareFisiere.getInstance().writeBulkTextToFile(candidatiScris, "./input/Candidati.csv");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClasaServiciu c = new ClasaServiciu();
        //Pentru a rula scrierea initiala...
        //scriereInitiala();

        c.incarcareInitiala();



        int ok = 1, i;

        while(ok == 1){
            System.out.println();
            System.out.println();
            System.out.println("MENIU");
            System.out.println("Pentru a crea o fisa de inscriere apasati tasta 1.");
            System.out.println("Pentru a afisa fisele de inscriere existente apasati tasta 2.");
            System.out.println("Pentru a sterge o fisa de inscriere apasati tasta 3.");
            System.out.println("Pentru a calcula taxa de inscriere pentru o fisa apasati tasta 4.");
            System.out.println("Pentru a adauga un examen apasati tasta 5.");
            System.out.println("Pentru a afisa lista de examene apasati tasta 6.");
            System.out.println("Pentru a sterge un examen apasati tasta 7.");
            System.out.println("Pentru a verifica daca un student a intrat la buget sau taxa apasati tasta 8.");
            System.out.println("Pentru a verifica daca un student a fost respins la o specializare apasati tasta 9.");
            System.out.println("Pentru a realiza o impartire pe sali pentru un examen tastati 10.");
            System.out.println("Pentru a iesi din meniu apasati tasta 0.");
            System.out.println();
            // System.out.println(c.getNumarFise());
            i = scanner.nextInt();
            switch (i){
                case 0:
                    Audit.getInstance().writeLogs("Iese din program");
                    ok = 0;
                    break;
                case 1:
                    Audit.getInstance().writeLogs("Inscriere candidat");
                    c.inscriereCandidat();
                    break;
                case 2:
                    Audit.getInstance().writeLogs("Afiseaza fisele de inscriere");
                    c.afiseazaFiseleDeInscriere();
                    break;
                case 3:

                    System.out.println("Pozitia fisei pe care doriti sa o stergeti?");
                    for(int j = 0; j < c.getFiseInscriere().size(); j++){
                        System.out.println((j+1) + "." + c.getFiseInscriere().get(j).getCandidat().getPrenume());
                    }
                    int x;
                    x = scanner.nextInt();
                    c.stergeFisaInscriere(x-1);
                    Audit.getInstance().writeLogs("Sterge fisa de inscriere " + (x));
                    break;
                case 4:
                    Audit.getInstance().writeLogs("Calculeaza taxa de inscriere");
                    System.out.println("Pentru ce fisa de inscriere doriti sa calculati taxa?");
                    for(int j = 0; j < c.getFiseInscriere().size(); j++){
                        System.out.println((j+1) + "." + c.getFiseInscriere().get(j).getCandidat().getPrenume());
                    }
                    int y = scanner.nextInt();
                    y--;
                    c.getFiseInscriere().get(y).setTaxa(c.calculTaxa(y));
                    System.out.println(c.getFiseInscriere().get(y).getTaxa());
                    break;
                case 5:
                    Audit.getInstance().writeLogs("Adauga examen");
                    c.adaugaExamen();
                    break;
                case 6:
                    Audit.getInstance().writeLogs("Afiseaza examen");
                    c.afiseazaExamene();
                    break;
                case 7:
                    Audit.getInstance().writeLogs("Sterge examen");
                    System.out.println("Ce examen doriti sa stergeti?");
                    for (int j = 0; j < c.getNumarExamene(); j++){
                        System.out.println((j+1) + "." + c.getExamene()[j].getSpecializare().getDenumire());
                    }
                    x = scanner.nextInt();
                    c.stergeExamen(x-1);
                    break;
                case 8:
                    Audit.getInstance().writeLogs("Verifica daca un student a intrat la buget sau taxa");
                    System.out.println("Ce vreti sa verificati?");
                    System.out.println("Buget - pentru a verifica daca un candidat a intrat la buget");
                    System.out.println("Taxa - pentru a verifica daca un candidat a intrat la taxa");
                    String alegere = scanner.next();
                    if(alegere.equals("Buget")) {
                        System.out.println("Pentru ce fisa de inscriere doriti sa verificati daca a intrat la buget?");
                        for (int j = 0; j < c.getFiseInscriere().size(); j++) {
                            System.out.println((j+1) + "." + c.getFiseInscriere().get(j).getCandidat().getPrenume());
                        }
                        x = scanner.nextInt();
                        x--;
                        System.out.println("Pentru care dintre specializari?");
                        for (Specializare specializare: c.getFiseInscriere().get(x).getSpecializari()) {
                            System.out.println(specializare.getDenumire());
                        }
                        String denSpec = scanner.next();
                        Specializare specializare = new Specializare(denSpec);
                        System.out.println("Nota minima buget: " + specializare.getNotaMinBuget());
                        System.out.println("Nota de admitere a candidatului: " + c.getFiseInscriere().get(x).getNotaAdmitere());
                        if (c.admisBuget(x, specializare)) {
                            System.out.println("Pentru specializarea " + specializare.getDenumire() + " candidatul este admis la buget");
                        } else {
                            System.out.println("Pentru specializarea " + specializare.getDenumire() + " candidatul nu este admis la buget");
                        }
                    }
                    if(alegere.equals("Taxa")) {
                        System.out.println("Pentru ce fisa de inscriere doriti sa verificati daca a intrat la taxa?");
                        for (int j = 0; j < c.getFiseInscriere().size(); j++) {
                            System.out.println((j+1) + "." + c.getFiseInscriere().get(j).getCandidat().getPrenume());
                        }
                        x = scanner.nextInt();
                        x--;
                        System.out.println("Pentru care dintre specializari?");
                        for (Specializare specializare: c.getFiseInscriere().get(x).getSpecializari()) {
                            System.out.println(specializare.getDenumire());
                        }
                        String denSpec = scanner.next();
                        Specializare specializare = new Specializare(denSpec);
                        System.out.println("Nota minima taxa: " + specializare.getNotaMinTaxa());
                        System.out.println("Nota de admitere a candidatului: " + c.getFiseInscriere().get(x).getNotaAdmitere());
                        if (c.admisTaxa(x, specializare)) {
                            System.out.println("Pentru specializarea " + specializare.getDenumire() + " candidatul este admis la taxa");
                        } else {
                            System.out.println("Pentru specializarea " + specializare.getDenumire() + " candidatul nu este admis la taxa");
                        }
                    }
                    break;
                case 9:
                    Audit.getInstance().writeLogs("Verifica daca un student a fost respins");
                    System.out.println("Respins - pentru a verifica daca un candidat a fost respins");
                    System.out.println("Pentru ce fisa de inscriere doriti sa verificati daca candidatul este respins?");
                    for (int j = 0; j < c.getFiseInscriere().size(); j++) {
                        System.out.println((j+1) + "." + c.getFiseInscriere().get(j).getCandidat().getPrenume());
                    }
                    x = scanner.nextInt();
                    x--;
                    System.out.println("Pentru care dintre specializari?");
                    for (Specializare specializare: c.getFiseInscriere().get(x).getSpecializari()) {
                        System.out.println(specializare.getDenumire());
                    }
                    String denSpec = scanner.next();
                    Specializare specializare = new Specializare(denSpec);
                    System.out.println("Nota minima taxa: " + specializare.getNotaMinTaxa());
                    System.out.println("Nota de admitere a candidatului: " + c.getFiseInscriere().get(x).getNotaAdmitere());
                    if (c.respins(x, specializare)) {
                        System.out.println("La spcializarea " + specializare.getDenumire() + " candidatul este respins.");
                    }
                    break;
                case 10:
                    Audit.getInstance().writeLogs("Executa o impartire in sali");
                    x = c.impartireInSali();
                    if (x == 0) System.out.println("Examenul nu va avea loc pentru ca nu exista participanti.");
                    break;
                default:
                    break;
            }
        }


//        System.out.println("Mihai trebuie sa plateasca " + fisaInscriereMihai.calculTaxa() + " lei pentru a se inscrie.");

//        candidat1.setNotaExamen();
//        System.out.println("Mihai are media de admitere " + candidat1.calculNotaAdmitere(candidat1.getNote()));

//        System.out.println(specializareInformatica.getDenumire());
//        System.out.println(candidati.length);
//        System.out.println(supraveghetori.length);
//        System.out.println(saliExamen.length);

//        Examen examenInfo = new Examen(specializareInformatica, candidati, supraveghetori, saliExamen);
//        System.out.println(examenInfo.impartireInSali());
//        System.out.println(examenInfo.supraveghetoriNecesari());

//        //LICEE:
//
//        Liceu liceu1 = new Liceu("Bucuresti", "Timotei Cipariu", "real");
//        Liceu liceu2 = new Liceu("Ploiesti", "Nichita Stanescu", "real");
//        Note noteMihai = new Note(7.0f, 5.6f);
//
//        Specializare specializareTestInfo = new Informatica();
//        Specializare specializareTestMate = new Matematica();
//        Specializare specializareTestCTI = new CTI();
//        Specializare []specializariFMI = {specializareTestCTI, specializareTestInfo, specializareTestMate};
//        Facultate facultateTest = new Facultate("Matematica si Informatica", specializariFMI );
//
//        //adaug manual 2 candidati pentru testare
//        Candidat candidat1 = new Candidat("Serbanica", "Mihail",  22, liceu1, noteMihai);
//        Candidat candidat2 = new Candidat("Popescu", "Andrei",  22, liceu1, noteMihai);
//        c.setNumarFise(c.getNumarFise() + 2);
//        Candidat []candidati = {candidat1, candidat2};
//
//        Specializare []specializariTest = {specializareTestCTI, specializareTestInfo};
//        FisaInscriere fisaTest = new FisaInscriere(candidat1, facultateTest, specializariTest);
//        FisaInscriere []fiseTest ={fisaTest};
//
//        c.setFiseInscriere(fiseTest);
//        c.setNumarFise(1);
//        c.afiseazaFiseleDeInscriere();
//
//        //SUPRAVEGHETORI:
//        Supraveghetor supraveghetor1 = new Supraveghetor("Cheptea", "Ramona");
//        Supraveghetor supraveghetor2 = new Supraveghetor("Dragan","Ion");
//        Supraveghetor []supraveghetori = {supraveghetor1, supraveghetor2};
//
//        //SALI EXAMEN:
//        SalaExamen sala1 = new SalaExamen("Pompeiu", 50, 2);
//        SalaExamen sala4 = new SalaExamen("Stoilow", 50, 1);
//        SalaExamen sala2 = new SalaExamen("Haret", 60, 0);
//        SalaExamen sala3 = new SalaExamen("Titeica", 60, 3);
//        SalaExamen []saliExamen = {sala1, sala2, sala3, sala4};

//


    }
}
