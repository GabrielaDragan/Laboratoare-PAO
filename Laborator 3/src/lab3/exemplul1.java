package lab3;

import java.util.Arrays;

public class exemplul1 {

    public static void main(String[] args) {

        float [] values = new float[3];
        float [] values2 = new float[3];
        int [] intvals = new int[5];

        values[0] = 10.0f;
        values[1] = 20.0f;
        values[2] = 15.0f;

        values2[0] = 10.0f;
        values2[1] = 20.0f;
        values2[2] = 15.0f;

        //Arrays.sort(values);

        Arrays.fill(intvals, 3);

        System.out.println(Arrays.equals(values, values2));

        System.out.println(Arrays.binarySearch(values, 10.0f));



        for(int i = 0; i <= 4; i++)
        {
            System.out.println(intvals[i]);
        }

    }
}
