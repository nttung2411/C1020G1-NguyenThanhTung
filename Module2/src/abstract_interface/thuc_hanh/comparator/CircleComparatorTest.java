package abstract_interface.thuc_hanh.comparator;

import kethua.thuchanh.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle("Indigo",false,3.6);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles){
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);

        System.out.println("After-sorted");
        for (Circle circle : circles){
            System.out.println(circle);
        }
    }
}
