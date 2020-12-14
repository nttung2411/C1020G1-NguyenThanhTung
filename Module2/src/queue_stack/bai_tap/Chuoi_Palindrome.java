package queue_stack.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Chuoi_Palindrome {
    public static void main(String[] args) {
        Stack<Character> palindromeStack = new Stack<>();
        Queue<Character> palindromeQueue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra:");
        String palindrome = scanner.nextLine();

        for (int index = 0; index < palindrome.length(); index++) {

            Character pushChar = palindrome.charAt(index);
            pushChar = pushChar.toLowerCase(pushChar);

            palindromeStack.push(pushChar);
            palindromeQueue.add(pushChar);
        }

        boolean flag = true;
        for (int index = 0; index < palindrome.length(); index++){
            if (!palindromeQueue.poll().equals(palindromeStack.pop())) {
                flag = false;
                break;
            }
        }

        if (flag == false){
            System.out.println("Không phải chuỗi Palindrome");
        } else {
            System.out.println("Đây là chuỗi Palindrome");
        }
    }
}
