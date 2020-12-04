package kethua.baitap.circle_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this(5.0,"brown");
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }

    @Override
    public String toString(){
        return "Bán kính hình tròn: "
                + getRadius()
                + " , màu sắc: " + getColor()
                + " , diện tích hình tròn: "
                + getArea();
    }
}
