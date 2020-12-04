package kethua.baitap.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(){
        this(4.0);
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume(){
        return this.height*this.getArea();
    }
    @Override
    public String toString(){
        return "Bán kính hình trụ: "
                + getRadius()
                + " , màu sắc : " + getColor()
                + " , chiều cao: " + getHeight()
                + " , diện tích: " + getArea()
                + " , thể tích: " + getVolume();
    }
}
