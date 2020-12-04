package Introduct.BaiTap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số USD muốn đổi");
        float usd = sc.nextFloat();
        float vnd = 23000*usd;
        System.out.printf("Số tiền đổi được là: %.2f VNĐ",vnd);
    }
}
