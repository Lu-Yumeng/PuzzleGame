package Util;

import java.util.Random;

public class CodeUtil {

    public static String getCode(){
        char[] arr = new char[52];
        for (int i = 0; i < 26; i++) {
            arr[i] = (char)(65+i);
            arr[i+26] = (char)(97+i);
        }
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        int num_index = r.nextInt(5);
        for (int i = 0; i < 5; i++) {
            if (i==num_index){
                sb.append(r.nextInt(10));
            } else{
                int index = r.nextInt(52);
                sb.append(arr[index]);
            }
        }
        return sb.toString();
    }
}
