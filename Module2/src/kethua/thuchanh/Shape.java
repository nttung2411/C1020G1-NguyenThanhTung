package kethua.thuchanh;

import abstract_interface.bai_tap.resizeable.Resizeable;

public class Shape implements Resizeable {
    private String color;
    private boolean filled;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }


    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea(){
        return 0.0;
    }
    public Shape(){
        this("green",true);
    }

    public Shape(String str , boolean is){
        this.color = str;
        this.filled = is;
    }
    public Shape(String str){
        this.color = str;
    }
    @Override
    public String toString(){
        return  "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    @Override
    public void resize(double percent) {
    }
}
