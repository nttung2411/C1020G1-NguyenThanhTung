package thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class MinhHoaInsertionSort {
    public static int[] list = {10,3,5,2,1,7,8,9};
    public static void insertionSort(int[] list){
        for(int i = 1 ; i < list.length ; i++){
            int numberCheck = list[i];
            int j = i-1;
            while(j >= 0 && list[j] > numberCheck){
                list[j+1] = list[j];
                j--;
            }
            System.out.println("Đổi số " + numberCheck + " xuống vị trí của " + list[j+1]);
            list[j+1] = numberCheck;
            System.out.println(Arrays.toString(list));
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for(int element : list){
            System.out.println(element);
        }
    }
}
