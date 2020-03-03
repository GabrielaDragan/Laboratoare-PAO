package Exercitii;

import java.util.Scanner;
public class Exercitiul2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int fi = scanner.nextInt();
        int fs = scanner.nextInt();
        if (fi!=fs){
            System.out.println(fi + "!=" + fs);
        }
        if (fi<fs){
            System.out.println(fi + "<" + fs);
        }
        if (fi>fs){
            System.out.println(fi + ">" + fs);
        }
        if (fi<=fs){
            System.out.println(fi + "<=" + fs);
        }
        if (fi>=fs){
            System.out.println(fi + "!=" + fs);
        }
        if (fi==fs){
            System.out.println(fi + "=" + fs);
        }
    }
}