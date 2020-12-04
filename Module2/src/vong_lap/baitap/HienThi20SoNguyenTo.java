package vong_lap.baitap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập só lượng số nguyên tố cần in:");
        int inputNumber = scanner.nextInt();
        int n = 2;
        int count = 0;
        while (count < inputNumber){
            boolean check = true;
            for (int i = 2 ; i <= Math.sqrt(n);i++){
                if (n % i == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                count++;
                System.out.println("Số nguyên tố thứ " + count + " là: " + n);
            } n++;
        }
    }
}
