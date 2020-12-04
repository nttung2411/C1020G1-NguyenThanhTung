package kethua.baitap.point_moveable;

import kethua.baitap.point2d_3d.Point2D;

import java.util.Arrays;

public class MovablePoint extends Point2D {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint(){

    }

    public MovablePoint(float x, float y, float xSpeed , float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed , float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] speedXY = {getXSpeed(),getYSpeed()};
        return speedXY;
    }


    public MovablePoint move(){
        float x = this.getX();
        float y = this.getY();
        x += this.getXSpeed();
        y += this.getYSpeed();
        this.setXY(x,y);
        return this;
    }
    @Override
    public String toString(){
        return "x , y : "
                + getX() + " "
                + getY()
                + " speed x , y = "
                + Arrays.toString(getSpeed());
    }
}
