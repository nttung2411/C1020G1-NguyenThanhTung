package arraylist_linkedlist.bai_tap;

public class ArrayListTest {
    public static void main(String[] args) {
       MyArrayList<Integer> listArray = new MyArrayList<Integer>(4);
       listArray.ensureCapacity(1);
       listArray.add(1);
       listArray.add(2);
        System.out.println(listArray);

       listArray.add(0,5);
        System.out.println(listArray);

        System.out.println(listArray.get(0));
        System.out.println(listArray.indexOf(5));

        System.out.println(listArray.remove(2));
        System.out.println(listArray);;

        MyArrayList<Integer> newMyList = new MyArrayList<Integer>();
        newMyList = listArray.clone();
        System.out.println(newMyList.get(1));

        System.out.println(listArray.size());
        listArray.clear();
        System.out.println(listArray);
        System.out.println(listArray.size());
    }
}
