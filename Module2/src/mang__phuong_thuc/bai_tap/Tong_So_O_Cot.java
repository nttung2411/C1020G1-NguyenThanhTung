package mang__phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Tong_So_O_Cot {
    public static void main(String[] args) {
        int array[][];
        Scanner input = new Scanner(System.in);
        int i;
        int j;
        System.out.println("Nhập độ dài mảng cha");
        i = input.nextInt();
        System.out.println("Nhập độ dài của các mảng con");
        j = input.nextInt();
        array = new int[i][j];
        for (int m = 0 ; m < array.length ; m++){
            for (int n = 0 ; n < array[m].length ; n++){
                System.out.println("Nhập số thứ " + (n+1) + " của mảng con thứ " + (m+1));
                array[m][n] = input.nextInt();
            }
        }
        for (int index = 0 ; index < array.length ; index++){
            System.out.println(Arrays.toString(array[index]));
        }
        int number;
        int sum = 0;
        do {
            System.out.println("Nhập số thứ tự mảng con muốn tính tổng");
            number = input.nextInt();
            if (number > array.length || number <= 0){
                System.out.println("Số nhập vào không hợp lệ");
            } else {
                for (int z = 0 ; z < array[number-1].length ; z++){
                    sum += array[number-1][z];
                }
            }
        } while (number > array.length);
        System.out.println("Tổng của mảng con thứ " + number + " là " + sum );
    }
}
