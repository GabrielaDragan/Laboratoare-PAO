package Admitere;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private static Audit instance = new Audit();

    public Audit() {
    }

    public static Audit getInstance(){
        return instance;
    }

    public void writeLogs(String action) {
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = dateNow.format(formatObj);
        GestionareFisiere.getInstance().scrieInContinuareCSV(action + "," + timestamp, "./output/logs.csv");
    }

}
