package accessModifier_static.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "Red";
    Circle(){

    }
    Circle(double r){
        radius = r ;
    }
    protected double getRadius(){
        return this.radius;
    }
    protected double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
}
