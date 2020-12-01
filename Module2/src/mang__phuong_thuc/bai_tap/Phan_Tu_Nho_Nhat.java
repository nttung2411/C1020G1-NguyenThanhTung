package mang__phuong_thuc.bai_tap;

import java.util.Scanner;

public class Phan_Tu_Nho_Nhat {
    public static void main(String[] args) {
        int arrayNumber[];
        int size = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length number");
        size = input.nextInt();
        arrayNumber = new int[size];
        for (int i = 0 ; i < arrayNumber.length ; i++){
            System.out.println("Input number " + (i+1) + "/" + (arrayNumber.length));
            arrayNumber[i] = input.nextInt();
        }
        int min = arrayNumber[0];
        for (int j = 1 ; j < arrayNumber.length ; j++){
            if (min > arrayNumber[j]){
                min = arrayNumber[j];
            }
        }
        System.out.print("Smallest number is " + min);
    }
}
