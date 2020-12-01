package mang__phuong_thuc.bai_tap;

import java.util.Scanner;

public class Dem_So_Lan_Ky_Tu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String str = scanner.nextLine();
        System.out.println("Nhập ký tự trong chuỗi");
        char check = scanner.next().charAt(0);
        int count = 0;
        boolean flag = true;
        for (int i = 0 ; i < str.length() ; i++){
            if (str.charAt(i) == check){
                count++;
                flag = false;
            }
        } if (flag){
            System.out.println("Ký tự không tìm thấy");
        } else {
            System.out.println("Số lần xuất hiện " + check + " là " + count + " lần");
        }
    }
}
