package queue_stack.thuc_hanh.stack;


public class GenericStackClient {
    public static void main(String[] args) {
        MyGenericStack<Integer> integerStack = new MyGenericStack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        System.out.println("Size integerStack after pop:" + integerStack.size());
        integerStack.pop();
        System.out.println("Size integerStack before pop:" + integerStack.size());

        MyGenericStack<String> stringStack = new MyGenericStack<>();
        stringStack.push("One");
        stringStack.push("Two");
        stringStack.push("Three");
        stringStack.push("Four");
        System.out.println("Size stringStack after pop:" + stringStack.size());
        stringStack.pop();
        System.out.println("Size stringStack before pop:" + stringStack.size());
    }
}
