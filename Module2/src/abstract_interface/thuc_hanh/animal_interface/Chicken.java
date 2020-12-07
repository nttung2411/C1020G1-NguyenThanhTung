package abstract_interface.thuc_hanh.animal_interface;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Cục...cục...cục...mứt";
    }

    @Override
    public String toEat() {
        return "Gà 7 món";
    }
}
