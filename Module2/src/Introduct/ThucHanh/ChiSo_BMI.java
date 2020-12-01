package Introduct.ThucHanh;

import java.util.Scanner;

public class ChiSo_BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chiều cao của bạn: ");
        double height = sc.nextDouble();
        System.out.print("Cân nặng của bạn: ");
        double weight = sc.nextDouble();
        double bmi = weight/Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18.5)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
