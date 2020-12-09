package danh_sach.thuc_hanh.my_list;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("New	York");
        linkedList.add("Atlanta");
        linkedList.add("Dallas");
        linkedList.add("Madison");

        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "	");
        }
    }
}
