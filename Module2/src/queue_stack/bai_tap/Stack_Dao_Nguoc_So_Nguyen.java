package queue_stack.bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class Stack_Dao_Nguoc_So_Nguyen {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<Integer>();
        int[] arrayInteger = {1,2,3,4,5};

        for(int element : arrayInteger){
            integerStack.push(element);
        }

        System.out.println(integerStack);

        for (int index = 0 ; index < arrayInteger.length ; index++){
            arrayInteger[index] = integerStack.pop();
        }

        System.out.println(Arrays.toString(arrayInteger));

        Stack<Character> stringStack = new Stack<Character>();
        String str = "CodeGym";
        char mWord;

        for(int index = 0 ; index < str.length() ; index++){
            mWord = str.charAt(index);
            stringStack.push(mWord);
        }

        System.out.println(stringStack);
        mWord = stringStack.pop();
        String newStr = str + mWord;
        System.out.println(newStr);
    }
}
