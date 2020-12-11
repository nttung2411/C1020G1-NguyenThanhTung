package arraylist_linkedlist.thuc_hanh.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("Testing");
        MyLinkedList ll = new MyLinkedList("BCA");
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(2,9);
        ll.add(4,10);
        ll.printList();
    }
}
