package arraylist_linkedlist.bai_tap;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    class Node {
        private Node next;
        Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public E remove(int index){
        Node temp = head;
        Object data;
        if (index == 0){
            data = temp.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        return (E) data;
    }

    public boolean remove(Object element) {
        Node temp = head;
        boolean check = false;
        for (int i = 0; i < numNodes; i++) {
            if (temp.equals(element)) {
                remove(i);
                check = true;
                break;
            }
            temp = temp.next;
        } return check;
    }

    public int size(){
        return numNodes;
    }

    public MyLinkedList<E> clone(){
        Node temp = head;
        int count = 0;
        MyLinkedList<E> newLinkedList = new MyLinkedList<>();
        while (temp != null){
            newLinkedList.add(count,(E)temp.data);
            count++;
            temp = temp.next;
        }
        return newLinkedList;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
