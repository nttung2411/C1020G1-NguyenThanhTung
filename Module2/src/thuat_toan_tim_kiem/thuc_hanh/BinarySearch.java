package thuat_toan_tim_kiem.thuc_hanh;

public class BinarySearch {
    public static int[] list = {1,2,3,5,10,12,20,30,80};
    public static int binarySearch(int[] list,int key){
        int low = 0;
        int high = list.length-1;
        while(high >= low){
            int mid = (low+high)/2;
            if (key < list[mid]){
                high = mid-1;
            } else if (key == list[mid]){
                return mid;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 12));
        System.out.println(binarySearch(list, 79));
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 80));
    }
}
