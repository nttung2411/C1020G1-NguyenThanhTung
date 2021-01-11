package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckClass {
    private static Scanner scanner = new Scanner(System.in);

    public static int checkNumber(int maxNumber) {
        boolean flag;
        int chooseNumber = 0;
        do {
            System.out.print("Nhập số muốn chọn (không được quá " + maxNumber + ")" + " : ");
            try {
                flag = true;
                chooseNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Không được nhập chữ!");
                scanner.nextLine();
                flag = false;
            }
        } while (!flag || chooseNumber < 1 || chooseNumber > maxNumber);
        return chooseNumber;
    }

    public static double checkPrice() {
        boolean flag;
        double price = 1;
        do {
            System.out.println("Giá bán: ");
            try {
                flag = true;
                price = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Không được nhập chữ");
                scanner.nextLine();
                flag = false;
            }
            if (price < 1) {
                System.out.println("Giá phải là số dương");
            }
        } while (!flag || price < 1);
        return price;
    }

    public static int checkSoLuong(){
        boolean flag;
        int soLuong = 1;
        do{
            System.out.println("Nhập số lượng:");
            try{
                flag = true;
                soLuong = scanner.nextInt();
            }catch (InputMismatchException e) {
                System.err.println("Không được nhập chữ");
                scanner.nextLine();
                flag = false;
            } if (soLuong < 1) {
                System.out.println("Số lượng phải là số dương");
            }
        } while (!flag || soLuong < 1);
        return soLuong;
        }
    }
