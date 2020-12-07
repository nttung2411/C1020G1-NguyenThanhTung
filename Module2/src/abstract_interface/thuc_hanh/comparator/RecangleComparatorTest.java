package abstract_interface.thuc_hanh.comparator;

import kethua.thuchanh.Rectangle;

import java.util.Arrays;

public class RecangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(5.0,3.7);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(3.0,1.7);
        System.out.println("Trước khi sắp xếp");
        for (Rectangle rectangle:rectangles) {
            System.out.println(rectangle);
        }
        RectangleComparator rectangleComparator = new RectangleComparator();
        Arrays.sort(rectangles,rectangleComparator);

        System.out.println("Sau khi sắp xếp");
        for (Rectangle rectangle:rectangles) {
            System.out.println(rectangle);
        }
    }
}
