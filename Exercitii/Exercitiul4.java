package Exercitii;

import java.util.Scanner;

public class Exercitiul4{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = 1;
        for (int i = 1; i <= n; i++)
            {
                p *= i;
            }
        System.out.println("Factorialul numarului "+ n + " este " + p);
    }
}