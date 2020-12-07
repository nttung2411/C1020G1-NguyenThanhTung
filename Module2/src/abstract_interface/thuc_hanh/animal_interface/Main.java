package abstract_interface.thuc_hanh.animal_interface;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (int i = 0 ; i < animals.length ; i++){
            System.out.println(animals[i]);
            if (animals[i] instanceof Chicken){
                Edible edible = (Chicken) animals[i];
                System.out.println(edible.toEat());
            }
        }
    }
}
