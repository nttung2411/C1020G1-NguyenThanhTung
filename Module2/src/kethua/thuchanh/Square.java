package kethua.thuchanh;

import abstract_interface.bai_tap.colorable.Colorable;
import abstract_interface.bai_tap.resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square(){
        this(1.0);
    }

    public Square(double side){
        super(side,side);
    }
    public Square(String color , boolean filled , double side){
        super(color,filled,side,side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double newSquare = this.getArea()*(percent/100+1);
        System.out.println(newSquare);
        System.out.println();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

