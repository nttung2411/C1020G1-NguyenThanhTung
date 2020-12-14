package queue_stack.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class Stack_Chuyen_Doi_Nhi_Phan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thập phân muốn đổi:");
        int inputNumber = scanner.nextInt();

        Stack<Integer> binary = new Stack<>();

        while (inputNumber != 0){

            binary.push(inputNumber%2);

            inputNumber = inputNumber / 2;
        }
        System.out.println(binary);
    }
}
