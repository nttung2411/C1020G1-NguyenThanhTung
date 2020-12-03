package accessModifier_static.thuc_hanh;

public class Car {
    private String name;
    private String color;
    static int numberOfCar = 0;
    public Car(String nameCar , String colorCar){
        name = nameCar;
        color = colorCar;
        numberOfCar++;
    } String displayCar(){
        return name + " " + color;
    }
}
