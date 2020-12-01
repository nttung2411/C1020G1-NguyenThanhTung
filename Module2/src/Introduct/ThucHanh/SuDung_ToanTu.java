package Introduct.ThucHanh;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SuDung_ToanTu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Width: ");
        width = input.nextFloat();
        System.out.println("Enter Height: ");
        height = input.nextFloat();
        float area = width * height;
        System.out.println("Area is: " + area);
    }
}
