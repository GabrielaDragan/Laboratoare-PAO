package lab3;

public class exemplul2 {

    public static void main(String[] args) {
        int val1 = 10;
        int val2 = 20;

        System.out.println("val1 = " + val1);
        System.out.println("val2 = " + val2);

        swap(val1, val2);

        System.out.println("val1 = " + val1);
        System.out.println("val2 = " + val2);
    }

    public static void swap(int i, int j){
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        int k = i;
        i = j;
        j = k;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }
}
