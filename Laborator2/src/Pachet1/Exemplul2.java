package Pachet1;

import java.util.Scanner;

public class Exemplul2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int [][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        System.out.println("Matrix length is:" + matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int[] numbers = {1, 2, 3};
    }
}
