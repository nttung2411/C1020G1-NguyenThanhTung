package mang__phuong_thuc.bai_tap;

import java.util.Arrays;

public class Gop_Mang {
    public static void main(String[] args) {
        int array1[] = new int[5];
        int array2[] = new int[4];
        for (int i = 0 ; i < array1.length ; i++){
            array1[i] = i +1;
        }
        for (int j = 0 ; j < array2.length ; j++){
            array2[j] = j + 6;
        }
        int array3[] = new int[array1.length+array2.length];
        for (int z = 0 ; z < array1.length ; z++){
            array3[z] = array1[z];
        }
        for (int e = 0 ; e < array2.length ; e++){
            array3[array1.length+e] = array2[e];
        }
        System.out.println(Arrays.toString(array1) + "\t");
        System.out.println(Arrays.toString(array2) + "\t");
        System.out.println(Arrays.toString(array3) + "\t");
    }
}
