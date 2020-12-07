package abstract_interface.thuc_hanh.interface_comparable;

import kethua.thuchanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle(){

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String str, boolean is, double radius) {
        super(str, is, radius);
    }

    @Override
    public int compareTo(ComparableCircle o){
        if(getRadius()> o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
