package Exercitii;

import java.util.Scanner;

public class Exercitiul6{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0, b = 1, aux;
        if(n == 0){
            System.out.print(a);
        }
        if(n == 1){
            System.out.print(b);
        }
        if(n > 1){
            for(int i = 2; i <= n; i++){
                aux = b;
                b = a + b;
                a = aux;
            }
            System.out.print(a);
        }
    }
}