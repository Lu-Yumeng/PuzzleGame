package Test;

import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        int[] arr = new int[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // shuffle
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }

        // return a 4*4 array
        // traverse new 2D array
        int[][] data = new int[4][4];

//        int ind = 0;
//        for (int i = 0; i < data.length; i++) {
//            for (int i1 = 0; i1 < data[i].length; i1++) {
//                data[i][i1] = arr[ind];
//                ind++;
//            }
//        }


        // traverse the 1D array
        for (int i = 0; i < arr.length; i++) {
            data[i/4][i%4] = arr[i];
        }


        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data[i].length; i1++) {
                System.out.println(data[i][i1]);

            }
        }
    }
}
