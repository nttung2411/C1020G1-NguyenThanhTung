package danh_sach.thuc_hanh.linked_list;

import javax.xml.soap.Node;

public class MyLinkedList {
    private Note head;
    private int number;
    public MyLinkedList(Object data){
        head = new Note (data);
    }
    private class Note{
        private Note next;
        private Object data;

        public Note(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    public void add(int index,Object data){
        Note temp = head;
        Note holder;
        for (int i = 0 ; i < index-1 && temp.next != null;i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Note(data);
        temp.next.next = holder;
        number++;
    }

    public void addFirst(Object data){
        Note temp = head;
        head = new Note(data);
        head.next = temp;
        number++;
    }

    public Note get(int index){
        Note temp = head;
        for (int i=0 ; i<index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Note temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
