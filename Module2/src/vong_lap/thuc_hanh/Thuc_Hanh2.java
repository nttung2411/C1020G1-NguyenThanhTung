package vong_lap.thuc_hanh;

import java.util.Scanner;

public class Thuc_Hanh2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate = 0;
        double total = 0;
        System.out.println("Nhập số tháng muốn gửi");
        int month = scanner.nextInt();
        System.out.println("Nhập số tiền muốn gửi");
        double money = scanner.nextDouble();
        switch (month){
            case 1:
            case 2:
            case 3:
                rate = 3.5;
                break;
            case 4:
            case 5:
            case 6:
                rate = 4;
                break;
            case 7:
            case 8:
            case 9:
                rate = 4.5;
                break;
            default:
                rate = 5.5;
        } for (int i = 0 ; i < month ; i++){
            total += money * rate / 100 / 12;
        }
        System.out.printf("Số tiền lãi là: %.2f",total);
    }
}
