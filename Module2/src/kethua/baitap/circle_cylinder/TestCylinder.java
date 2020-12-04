package kethua.baitap.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(6.0);
        Cylinder cylinder3 = new Cylinder(5.5,"white",4.5);
        System.out.println(cylinder1);
        System.out.println(cylinder2);
        System.out.println(cylinder3);
    }
}
