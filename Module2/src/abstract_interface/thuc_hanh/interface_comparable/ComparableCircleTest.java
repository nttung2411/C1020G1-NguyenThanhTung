package abstract_interface.thuc_hanh.interface_comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(5.0);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("Indigo",false,3.6);

        System.out.println("Pre-sorted");
        for (ComparableCircle circle : circles){
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}