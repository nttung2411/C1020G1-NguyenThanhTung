package mang__phuong_thuc.bai_tap;


public class Phan_Tu_Lon_Nhat {
    public static void main(String[] args) {
        int arrayNumber[][] = {{13,2,3,4},
                              {5,60,7,8},
                              {9,10,11,12}};
        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < arrayNumber.length ; i++){
            for (int z = 0 ; z < arrayNumber[i].length ; z++){
                if (arrayNumber[i][z]>max){
                    max = arrayNumber[i][z];
                    x = i+1;
                    y = z+1;
                }
            }
        }
        System.out.println("Giá trị lớn nhất là " + max + " tại dòng " + x + " cột " + y);
    }
}
