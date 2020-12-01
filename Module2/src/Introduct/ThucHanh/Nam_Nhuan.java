package Introduct.ThucHanh;

import java.util.Scanner;

public class Nam_Nhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập năm muốn kiểm tra: ");
        int year = sc.nextInt();
        if((year % 400 == 0) && (year % 100 == 0)){
            System.out.printf("Năm %d là năm nhuận",year);
        } else if (year % 4 == 0 && year % 100 != 0){
            System.out.printf("Năm %d là năm nhuận",year);
        } else {
            System.out.printf("Năm %d không phải là năm nhuận",year);
        }
    }
}
