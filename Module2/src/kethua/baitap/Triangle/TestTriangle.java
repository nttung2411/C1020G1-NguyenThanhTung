package kethua.baitap.Triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài cạnh 1");
        double x = scanner.nextDouble();
        System.out.println("Nhập độ dài cạnh 2");
        double y = scanner.nextDouble();
        System.out.println("Nhập độ dài cạnh 3");
        double z = scanner.nextDouble();
        scanner.skip("\n");
        System.out.println("Màu sắc của tam giác");
        String color = scanner.nextLine();

        Triangle triangle = new Triangle(color,x,y,z);
        System.out.println(triangle);
    }
}
