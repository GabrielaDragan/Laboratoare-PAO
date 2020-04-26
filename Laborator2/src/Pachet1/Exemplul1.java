package Pachet1;

import java.util.Scanner;
public class Exemplul1 {
    public static void main(String[] args){
        int[] studentsGrades = new int[20];
        Scanner scanner = new Scanner(System.in);
        int x, s = 0, i = 0;
        x = scanner.nextInt();
        while (x != -1){
            studentsGrades[i] = x;
            s += x;
            x = scanner.nextInt();
            i++;
        }
        System.out.println(s/i);
    }
}
