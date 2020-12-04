package Introduct.BaiTap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc(từ 0 đến 999): ");
        int number = sc.nextInt();
        int one = (number % 10);
        int ten;
        if (number < 100){
            ten = (number - one) / 10;
        } else {
            ten = ((number - one) / 10) % 10;
        }
        int hundred = (((number - one) / 10) - ten)/10;
        String ones = null;
        String tens = null;
        String huns = null;
        switch (one){
            case 0:
                if (ten == 1){
                    ones = "ten";
                } else {
                    ones = "";
                }
                break;
            case 1:
                if (ten != 1){
                    ones = "one";
                } else {
                    ones = "eleven";
                }
            break;
            case 2:
                if (ten != 1){
                    ones = "two";
                } else {
                    ones = "twelve";
                }
            break;
            case 3:
                if (ten != 1){
                    ones = "three";
                } else {
                    ones = "thirteen";
                }
            break;
            case 4:
                if (ten != 1){
                    ones = "four";
                } else {
                    ones = "fourteen";
                }
            break;
            case 5:
                if (ten != 1){
                    ones = "five";
                } else {
                    ones = "fifteen";
                }
            break;
            case 6:
                if (ten != 1){
                    ones = "six";
                } else {
                    ones = "sixteen";
                }
            break;
            case 7:
                if (ten != 1){
                    ones = "seven";
                } else {
                    ones = "seventeen";
                }
            break;
            case 8:
                if (ten != 1){
                    ones = "eight";
                } else {
                    ones = "eighteen";
                }
            break;
            case 9:
                if (ten != 1){
                ones = "nine";
            } else {
                ones = "nineteen";
            }
            break;
            default:
                ones = "";
        }
        switch (ten){
            case 2: tens = "twenty";
                break;
            case 3: tens = "thirty";
                break;
            case 4: tens = "forty";
                break;
            case 5: tens = "fifty";
                break;
            case 6: tens = "sixty";
                break;
            case 7: tens = "seventy";
                break;
            case 8: tens = "eighty";
                break;
            case 9: tens = "ninety";
                break;
            default:
                tens = "";
        }
        switch (hundred){
            case 1: huns = "one hundred";
                break;
            case 2: huns = "two hundred";
                break;
            case 3: huns = "three hundred";
                break;
            case 4: huns = "four hundred";
                break;
            case 5: huns = "five hundred";
                break;
            case 6: huns = "six hundred";
                break;
            case 7: huns = "seven hundred";
                break;
            case 8: huns = "eight hundred";
                break;
            case 9: huns = "nine hundred";
                break;
        }
        if (number >= 0 && number < 20){
            if (number == 0){
                System.out.println("zero");
            }
            else {
                System.out.println(ones);
            }
        } else if (number < 100){
            System.out.println(tens + " " + ones);
        } else if (number <1000) {
            if (number % 100 == 0) {
                System.out.println(huns);
            } else {
                System.out.println(huns + " and " + tens + " " + ones);
            }
        } else {
            System.out.println("Số nhập không hợp lệ");
        }
    }
}
