package kethua.thuchanh;

import abstract_interface.bai_tap.resizeable.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double length;

    public Rectangle(){
        this(1.0,1.0);
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String str, boolean is, double width, double length) {
        super(str, is);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return this.length*this.width;
    }

    public double getPerimeter(){
        return (this.length + this.width)*2;
    }
    @Override
    public String toString(){
        return "A rectangle with width: "
                + getWidth()
                + " and length " + getLength()
                + " , which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double newRectangle  = this.getArea()*(percent/100+1);
        System.out.println(newRectangle);
        System.out.println();
    }
}
