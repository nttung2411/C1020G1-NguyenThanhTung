package kethua.baitap.point2d_3d;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2Da = new Point2D();
        Point2D point2Db = new Point2D();
        Point2D point2Dc = new Point2D(5.0f,6.5f);
        point2Da.setX(2.5f);
        point2Da.setY(3.5f);
        point2Db.setXY(3.5f,5.5f);
        System.out.println(point2Da);
        System.out.println(point2Db);
        System.out.println(point2Dc);

        Point3D point3Da = new Point3D();
        Point3D point3Db = new Point3D();
        Point3D point3Dc = new Point3D(10.5f,5.6f,4.4f);
        point3Da.setX(4.0f);
        point3Da.setY(2.0f);
        point3Da.setZ(5.5f);

        point3Db.setXYZ(5.3f,5.5f,15.5f);

        System.out.println(point3Da);
        System.out.println(point3Db);
        System.out.println(point3Dc);

    }
}
