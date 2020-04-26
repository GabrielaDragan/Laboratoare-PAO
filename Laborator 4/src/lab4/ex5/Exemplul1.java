package lab4.ex5;

public class Exemplul1 {

    public static void main(String[] args) {
        String s1 = "vara";
        String s2 = new String("toamna");

        String s = s2.toUpperCase();
        //System.out.println(s2);

        StringBuilder sb = new StringBuilder();
        sb.append("Vara asta stau acasa!");

        sb.reverse();
        System.out.println(sb);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("vara asta nu stau acasa!");

        System.out.println(stringBuffer);
        stringBuffer.deleteCharAt(5);
        System.out.println(stringBuffer);
    }
}
