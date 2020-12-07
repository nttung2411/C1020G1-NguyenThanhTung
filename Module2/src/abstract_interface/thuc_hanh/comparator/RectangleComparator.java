package abstract_interface.thuc_hanh.comparator;

import kethua.thuchanh.Rectangle;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle c1, Rectangle c2){
        if (c1.getArea() > c2.getArea()) return 1;
        else if (c1.getArea() < c2.getArea()) return -1;
        else return 1;
    }
}
