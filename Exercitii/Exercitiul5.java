package Exercitii;

import java.util.Scanner;

public class Exercitiul5 {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int ok = 1;
    for(int i = 2; i<=n/2; i++)
    {
        if(n%i == 0) ok = 0;
    }
    if(ok==0){
        System.out.print("Numarul nu e prim");
    }
    else
        System.out.print("Numar prim");
    }
}