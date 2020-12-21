package thuat_toan_sap_xep.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] list){
        for(int i = 1 ; i < list.length ; i++){
            int numberCheck = list[i];
            int j = i-1;
            while(j >= 0 && list[j] > numberCheck){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = numberCheck;
        }
    }

    public static void main(String[] args) {
        int[] arrayNumber = {10,3,2,1,5,7,9,1};
        insertionSort(arrayNumber);
        System.out.println(Arrays.toString(arrayNumber));
    }
}
