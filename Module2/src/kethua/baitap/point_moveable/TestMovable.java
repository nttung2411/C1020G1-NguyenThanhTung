package kethua.baitap.point_moveable;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setXY(5,7);
        movablePoint.setSpeed(12,10);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
