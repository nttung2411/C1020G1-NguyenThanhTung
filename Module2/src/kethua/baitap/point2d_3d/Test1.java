package kethua.baitap.point2d_3d;

public class Test1 {
    private int age;
    private String name;
    private static int count;
    public Test1(String name,int age){
        this.name = name;
        this.age = age;
        count++;
    }
    @Override
    public String toString(){
        return "Name: " + this.name
                + " , age: " + this.age
                + count;
    }
}
