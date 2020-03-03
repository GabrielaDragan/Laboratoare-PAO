package Exercitii;

import java.util.Scanner;
public class Exercitiul7{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ok;
        for(int j = n/2; j >= 2; j--){
            if(n%j == 0){
                ok = 1;
                for(int i = 2; i<= j/2; i++){
                    if(j%i == 0){
                        ok = 0;
                    }
                }
                if(ok == 1){
                    System.out.print(j);
                    break;
                }
            }
        }
    }
}