package debug_xulyngoaile.bai_tap;


import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 3 cạnh của tam giác");
        int edge1 = scanner.nextInt();
        int edge2 = scanner.nextInt();
        int edge3 = scanner.nextInt();
        try {
            Triangle triangle = new Triangle(edge1,edge2,edge3);
            System.out.println(triangle);
        } catch (IllegalTriangleException e){
            System.err.println(e.getMessage());
        }
    }
}
