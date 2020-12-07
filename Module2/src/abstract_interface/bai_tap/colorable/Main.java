package abstract_interface.bai_tap.colorable;

import kethua.thuchanh.Circle;
import kethua.thuchanh.Rectangle;
import kethua.thuchanh.Shape;
import kethua.thuchanh.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes2 = new Shape[3];
        shapes2[0] = new Circle(4.4);
        shapes2[2] = new Rectangle(2.3,3.1);
        shapes2[1] = new Square(5.1);
        for (int i = 0 ; i < shapes2.length ; i++){
            System.out.println("Diện tích: " + shapes2[i].getArea());
            if (shapes2[i] instanceof Square){
                Colorable colorable = (Square) shapes2[i];
                colorable.howToColor();
            }
        }
    }
}
