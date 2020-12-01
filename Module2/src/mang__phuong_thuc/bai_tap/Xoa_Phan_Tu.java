package mang__phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Xoa_Phan_Tu
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numberArray = {1,3,5,6,7,10,22,50,35};
        System.out.println("Input number to find");
        int number = input.nextInt();
        boolean check = true;
        for (int i = 0 ; i < numberArray.length ; i++){
            if (number == numberArray[i]){
                if (i < numberArray.length-1) {
                    int swap = 0;
                    swap = numberArray[i];
                    numberArray[i] = numberArray[i + 1];
                    numberArray[i + 1] = swap;
                } check = false;
            }
        }
        if (check){
            System.out.println("Not found " + number + " in array!");
        } else {
            numberArray[numberArray.length-1] = 0;
            System.out.println(Arrays.toString(numberArray));
        }
    }
}
