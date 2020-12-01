package mang__phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Tong_So_Cua_Duong_Cheo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng vuông");
        int inputNumber = input.nextInt();
        int array[][] = new int[inputNumber][inputNumber];
        int sum = 0;
        for (int m = 0 ; m < array.length ; m++){
            for (int n = 0 ; n < array.length ; n++){
                System.out.println("Nhập phần tử thứ " + (n+1) + " của mảng con thứ " + (m+1));
                array[m][n] = input.nextInt();
                if (m == n){
                    sum += array[m][n];
                }
            }
        }
        for (int i = 0 ; i < array.length ; i++){
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("Tổng của đường chéo có toạ độ bằng nhau: " + sum);
    }
}
