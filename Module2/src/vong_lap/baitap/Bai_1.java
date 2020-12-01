package vong_lap.baitap;

import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle(The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        System.out.println("Enter your choice:");
        while (true){
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for (int i = 1 ; i <= 3 ; i++){
                        for (int j = 1 ; j <= 7 ; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("1.Top-left");
                    System.out.println("2.Top-right");
                    System.out.println("3.Bottom-left");
                    System.out.println("4.Bottom-right");
                    System.out.println("Enter your choice:");
                    int number = scanner.nextInt();
                    switch (number){
                        case 1:
                            for (int i = 5 ; i >= 1 ; i--){
                                for (int j = i ; j >= 1 ; j--){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 2:
                            for (int i = 5 ; i >= 1 ; i--){
                                for (int z = 5 ; z > i ; z--){
                                    System.out.print(" ");
                                }
                                for (int j = i ; j >= 1 ; j--){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 3:
                            for (int i = 1 ; i <= 5 ; i++){
                                for (int j = 1 ; j <= i ; j++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                        case 4:
                            for (int i = 1 ; i <= 5 ; i++){
                                for (int j = 4 ; j >= i ; j--){
                                    System.out.print(" ");
                                } for (int z = 1 ; z <= i ; z++){
                                    System.out.print("*");
                                }
                                System.out.print("\n");
                            }
                            break;
                    }
                    break;
                case 3:
                    for (int i = 1 ; i <= 5 ; i++){
                        for (int j = 4 ; j >= i ; j--){
                            System.out.print(" ");
                        } for (int z = 1 ; z <= i ; z++){
                            System.out.print(" *");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
