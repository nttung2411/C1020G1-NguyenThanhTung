package vong_lap.thuc_hanh;

import java.util.Scanner;

public class Thuc_Hanh3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số nguyên a:");
        int a = scanner.nextInt();
        System.out.println("Nhập số nguyên b:");
        int b = scanner.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0){
            System.out.println("Không có ƯCLN");
        } else if (a == 0){
            System.out.printf("Ước chung lớn nhất là: %d",b);
            return;
        } else if (b == 0){
            System.out.printf("Ước chung lớn nhất là: %d",a);
            return;
        }
        while (a != b){
            if (a > b){
                a = a -b;
            } else {
                b = b - a;
            }
        }
        System.out.printf("Ước chung lớn nhất của a,b: %d",a);
    }
}
