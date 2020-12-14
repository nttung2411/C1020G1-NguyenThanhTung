package queue_stack.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class Stack_Kiem_Tra_Bieu_Thuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập biểu thức muốn kiểm tra:");
        String mathExpression = scanner.nextLine();

        Stack<Character> checkStack = new Stack<>();
        boolean flag = true;
        for(int index = 0 ; index < mathExpression.length() ; index++){
            char sym = mathExpression.charAt(index);
            if (sym == '('){
                checkStack.push(sym);
             } else if (sym == ')'){
                if (checkStack.size() == 0){
                    flag = false;
                } else {
                    checkStack.pop();
                }
            }
        }

        System.out.println(flag);
        if (checkStack.size() == 0 && flag == true){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
