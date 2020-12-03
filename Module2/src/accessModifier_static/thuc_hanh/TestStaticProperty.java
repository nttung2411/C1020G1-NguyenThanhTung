package accessModifier_static.thuc_hanh;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("MazDa","Red");
        System.out.println(Car.numberOfCar + " " + car1.displayCar());
        Car car2 = new Car("Huyndai","Brown");
        System.out.println(Car.numberOfCar + " " + car2.displayCar());
    }
}
