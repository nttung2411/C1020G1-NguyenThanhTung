package mang__phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Them_Phan_Tu {
    public static void main(String[] args) {
        int[] arrayNumber = {10,4,6,7,8,0};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cần chèn");
        int inputNumber = input.nextInt();
        int index;
        do {
            System.out.println("Nhập vị trí cần chèn(không được chèn đầu và cuối)");
            index = input.nextInt();
        } while (index <= 1 || index >= arrayNumber.length);
        for (int i = arrayNumber.length-1 ; i >= index ; i--){
            int swap = 0;
            swap = arrayNumber[i];
            arrayNumber[i] = arrayNumber[i-1];
            arrayNumber[i-1] = swap;
        }
        arrayNumber[index-1] = inputNumber;
        System.out.println(Arrays.toString(arrayNumber));
    }
}
