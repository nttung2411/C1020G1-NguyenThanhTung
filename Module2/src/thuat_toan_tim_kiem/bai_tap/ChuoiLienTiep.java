package thuat_toan_tim_kiem.bai_tap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChuoiLienTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra:");
        String inputString = scanner.nextLine();

        List<String> listString = new ArrayList<>();

        listString.add(""+inputString.charAt(0));

        int count = 0;
        for(int index = 0 ; index < inputString.length()-1 ; index++){
            boolean check = inputString.charAt(index) - inputString.charAt(index+1) < 0;
            if (check){
                String s = listString.get(count) + inputString.charAt(index+1);
                listString.set(count,s);
            } else {
                count++;
                listString.add(""+inputString.charAt(index+1));
            }
        }

        System.out.println(listString.toString());

        int lengthString = listString.get(0).length();
        int count2 = 0;
        for(String element : listString){
            if (element.length() > lengthString){
                lengthString = element.length();
                count2++;
            }
        }

        System.out.println(listString.get(count2));
    }
}
