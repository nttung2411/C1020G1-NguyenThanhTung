package object_and_class.bai_tap;

import java.util.Scanner;

public class Phuong_Trinh_Bac_2 {
    public static class QuadraticEquation{
        double a;
        double b;
        double c;
        public QuadraticEquation(){

        }
        public QuadraticEquation(double a , double b , double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public double getDiscriminant(){
            double delta = b*b - 4*a*c;
            return delta;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập số b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập số c:");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        if (delta > 0){
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.println("Phương trình có 2 nghiệm");
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } else if (delta == 0){
            double x = -b/(2*a);
            System.out.println("Phương trình có 1 nghiệm");
            System.out.println("x: " + x);
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
