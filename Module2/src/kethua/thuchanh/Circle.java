package kethua.thuchanh;

public class Circle extends Shape {
    private double radius;

    public Circle(){
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String str, boolean is, double radius) {
        super(str, is);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    @Override
    public String toString(){
        return "A circle with radius: "
                + getRadius() + " , "
                + "which is a subclass of "
                + super.toString();
    }
}
