package thuat_toan_tim_kiem.bai_tap;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class BinarySearch_DeQuy {
    private static int[] list = {1,2,3,5,10,12,20,30,80,90};

    private static int checkIndex = list.length/2;

    private  static int BinarySearch(int key , int[] list){
        if (key > list[checkIndex]){
            checkIndex++;
            BinarySearch(key,list);
        } else if(key < list[checkIndex]){
            checkIndex--;
            BinarySearch(key,list);
        }
        return checkIndex;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch(5,list));
    }
}
