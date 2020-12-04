package kethua.baitap.point2d_3d;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x , float y , float z){
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    public float[] getXYZ(){
        float[] xyz = {this.getX(),this.getY(),this.z};
        return xyz;
    }

    @Override
    public String toString(){
        return "x,y,z của Point3D là: " + Arrays.toString(getXYZ());
    }
}
