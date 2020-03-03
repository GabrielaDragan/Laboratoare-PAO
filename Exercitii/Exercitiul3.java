package Exercitii;

import java.util.Scanner;
public class Exercitiul3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = 0, i;
        for (i = 1; i<=n; i++){
            if (i%3==0 || i%5==0) {s = s+i;}
        }
                
        
    }
}