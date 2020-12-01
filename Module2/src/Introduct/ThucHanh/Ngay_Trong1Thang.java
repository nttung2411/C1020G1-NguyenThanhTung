package Introduct.ThucHanh;

import java.util.Scanner;

public class Ngay_Trong1Thang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tháng muốn kiểm tra: ");
        int month = sc.nextInt();
        String date = null;
        switch (month){
            case 2:
                date = "28 hoặc 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                date = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                date = "30";
                break;
        }
        if (date != null) System.out.printf("Tháng %d có %s ngày!",month,date);
        else System.out.println("Nhập số tháng không hợp lệ");
    }
}
