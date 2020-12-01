package vong_lap.thuc_hanh;

import java.util.Scanner;

public class Thuc_Hanh1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số muốn kiểm tra");
        int inputNumber = scanner.nextInt();
        if (inputNumber < 2){
            System.out.println("Không phải số nguyên tố");
        }
        else {
            int i;
            boolean check = true;
            for (i = 2;i <= Math.sqrt(inputNumber);i++){
                if (inputNumber % i == 0){
                    check = false;
                    break;
                }
            } if (check){
                System.out.println("Đây là số nguyên tố");
            } else {
                System.out.println("Đây không phải số nguyên tố");
            }
        }

    }
}
