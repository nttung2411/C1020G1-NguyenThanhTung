package object_and_class.bai_tap;

import java.util.Scanner;

public class Xay_Dung_Lop_Fan {
    public static class Fan{
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        private int speed = SLOW;
        private boolean isOn = false;
        private double radius = 5;
        private String color = "Blue";
        public Fan(){
        }
        public int getSpeed() {
            return speed;
        }
        public boolean getIsOn(){
            return isOn;
        }
        public double getRadius() {
            return radius;
        }
        public String getColor() {
            return color;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public void setOn(boolean on) {
            this.isOn = on;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String toString(){
            if(getIsOn()){
                return "Fan is on , Speed: " + getSpeed() + ", Color: " + getColor() + ", Radius: " + getRadius();
            } else {
                return "Fan is off , Radius: " + getRadius() + ", Color " + getColor();
            }
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setOn(true);
        fan1.setColor("Yellow");
        fan1.setRadius(10);
        fan1.setSpeed(fan1.FAST);

        fan2.setSpeed(fan2.MEDIUM);
        Scanner sc = new Scanner(System.in);
        int choose;
        while (true){
            System.out.println("1.Check Fan 1");
            System.out.println("2.Check Fan 2");
            System.out.println("3 To exit");
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println(fan1.toString() + "\n");
                    break;
                case 2:
                    System.out.println(fan2.toString() + "\n");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
