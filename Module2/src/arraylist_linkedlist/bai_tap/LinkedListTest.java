package arraylist_linkedlist.bai_tap;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        list.addFirst(14);
        list.printList();
    }
}
