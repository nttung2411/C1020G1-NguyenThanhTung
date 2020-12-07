package abstract_interface.bai_tap.resizeable;

import kethua.thuchanh.Circle;
import kethua.thuchanh.Rectangle;
import kethua.thuchanh.Shape;
import kethua.thuchanh.Square;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(3.3,3.5);
        shapes[2] = new Square(4.0);
        System.out.println("Kích thước trước khi tăng của hình tròn: " + shapes[0].getArea());
        System.out.println("Kích thước trước khi tăng của hình chữ nhật: " + shapes[1].getArea());
        System.out.println("Kích thước trước khi tăng của hình vuông: " + shapes[2].getArea());

        System.out.print("Kích thước sau khi tăng của hình tròn: ");
        shapes[0].resize(Math.floor(Math.random()*100)+1);

        System.out.print("Kích thước sau khi tăng của hình chữ nhật: ");
        shapes[1].resize(Math.floor(Math.random()*100)+1);

        System.out.print("Kích thước sau khi tăng của hình vuông: ");
        shapes[2].resize(Math.floor(Math.random()*100)+1);
    }
}
