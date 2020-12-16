package thuat_toan_tim_kiem.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChuoiTangDan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra:");
        String inputString = scanner.nextLine();

        String displayString = "" + inputString.charAt(0);
        int count = 0;

        for (int index = 1 ; index < inputString.length() ; index++){
            if (displayString.charAt(count)-inputString.charAt(index) < 0){
                displayString += inputString.charAt(index);
                count++;
            }
        }
        System.out.println(displayString);
    }
}
