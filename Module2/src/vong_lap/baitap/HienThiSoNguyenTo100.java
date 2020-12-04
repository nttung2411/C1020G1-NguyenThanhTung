package vong_lap.baitap;

public class HienThiSoNguyenTo100 {
    public static void main(String[] args) {
        for (int i = 2 ; i < 100 ; i++){
            boolean check = true;
            for (int j = 2 ; j <= Math.sqrt(i) ; j++){
                if (i % j == 0){
                    check = false;
                            break;
                }
            } if (check){
                System.out.println(i);;
            }
        }
    }
}
