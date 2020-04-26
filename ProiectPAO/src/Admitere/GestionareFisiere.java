package Admitere;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionareFisiere <T> {
    private static final GestionareFisiere<?> instance = new GestionareFisiere<Object>();

    private GestionareFisiere(){}

    public static GestionareFisiere<?> getInstance(){
        return instance;
    }


    public static Liceu citireLiceu(int i){
        String path = "./input/Licee.csv";
        Liceu liceu = null;
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))){
            for(int j = 0; j <= i; j++){
                String line = buffer.readLine();
                if (line != null){
                    String[] data = line.split(",");
                    liceu = new Liceu(data[0], data[1], data[2]);
                }
            }
        }catch (FileNotFoundException fnf){
            System.out.println("Eroare: FileNotFound");
            fnf.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return liceu;
    }


    public static Note citireNote(int i){
        String path = "./input/Note.csv";
        Note note = null;
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))){
            for( int j = 0; j <= i; j++){
                String line = buffer.readLine();
                if(line != null){
                    String[] data = line.split(",");
                    note = new Note(Float.parseFloat(data[0]), Float.parseFloat(data[1]));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return note;
    }

    public static List<Candidat> citireCandidati(){
        String path = "./input/Candidati.csv";
        List<Candidat> candidatList = new ArrayList<>();
        try(BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            int i = 0;
            while (line != null){
                String[] data = line.split(",");
                Liceu liceu = citireLiceu(i);
                Note note = citireNote(i);

                Candidat candidat = new Candidat(data[0], data[1], Integer.parseInt(data[2]), liceu, note);

                candidatList.add(candidat);
                line = buffer.readLine();
                i++;
            }
            return candidatList;
        } catch (IOException e){
            e.printStackTrace();
        }
        return candidatList;
    }

    public static Specializare[] citireSpecializari(){
        String path = "./input/Specializari.csv";
        Specializare[] specializari = new Specializare[10];
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            int i = 0;
            while (line != null) {
                String[] data = line.split(",");
                Specializare specializare = new Specializare(data[0], Integer.parseInt(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]), Integer.parseInt(data[4]));
                specializari[i] = specializare;
                i++;
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specializari;
    }



    public void scrieInContinuareCSV(String text, String path){
        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(path, true))) {
            buffer.write(text);
            buffer.newLine();
            buffer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeBulkTextToFile(ArrayList<String> text, String path) {
        
            //PrintWriter printWriter = new PrintWriter(new FileOutputStream(path));
            Iterator iterator = text.iterator();

            while(iterator.hasNext()) {
                String write = (String)iterator.next();
                scrieInContinuareCSV(write,path);
                //printWriter.println(write);
            }
            //printWriter.flush();
            //printWriter.close();


    }

}

