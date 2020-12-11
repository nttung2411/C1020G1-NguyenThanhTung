package arraylist_linkedlist.bai_tap;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public MyArrayList(){
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity){
        element = new Object[capacity];
    }

    public void add(int index , E e){
        if (size == element.length){
            addLength();
        }
            for (int i = size ; i > index; i--) {
                element[i] = element[i-1];
            }
            element[index] = e;
            size++;
    }

    public E remove(int index){
        Object hold = element[index];
        for (int i = index ; i < size ; i++){
            element[index] = element[index+1];
        }
        element[size-1] = null;
        size--;
        return (E) hold;
    }

    public int size(){
        return size;
    }

    public MyArrayList<E> clone(){
       MyArrayList<E> cloneArray = new MyArrayList<>();
       cloneArray.element = Arrays.copyOf(this.element,this.size);
       cloneArray.size = this.size;
       return cloneArray;
    }

    public boolean contains(E o){
        boolean checkContains = true;
        for (int i = 0 ; i < size ; i ++){
            if (element[i].equals(o)){
                checkContains = true;
            }else {
                checkContains = false;
            }
        }
        return checkContains;
    }

    public int indexOf(E o){
        int checkIndex = 0;
        for (int i = 0 ; i < size ; i++){
            if (element[i].equals(o)){
                checkIndex = i;
                break;
            } else {
                checkIndex = -1;
            }
        }
        return checkIndex;
    }

    public boolean add(E e){
        if (size == element.length){
            addLength();
        }
        element[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity){
        if (minCapacity <= element.length){
            System.out.println("Dung lượng đủ , k không cần tăng thêm");
        } else{
            element = Arrays.copyOf(element,minCapacity);
            System.out.println("Dung lượng mảng được tăng lên: " + minCapacity);
        }
    }

    public E get(int index){
        E elementGet = (E) element[index];
        return elementGet;
    }

    public void clear(){
        for (int i = 0 ; i < size ; i++){
            element[i] = null;
        }
        size = 0;
    }

    private void addLength(){
        element = Arrays.copyOf(element,element.length+1);
    }
    @Override
    public String toString() {
        return Arrays.toString(element);
    }
}
