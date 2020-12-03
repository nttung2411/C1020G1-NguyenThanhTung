package accessModifier_static.thuc_hanh;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(1,"Hoàng");
        Student s2 = new Student(2,"Dũng");
        Student s3 = new Student(3,"Long");
        s1.display();
        s2.display();
        s3.display();
    }
}
