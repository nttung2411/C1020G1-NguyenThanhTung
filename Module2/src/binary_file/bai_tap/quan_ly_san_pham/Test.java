package binary_file.bai_tap.quan_ly_san_pham;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {
    public static void readObject() {
        try (FileInputStream fileInputStream = new FileInputStream("Test.txt")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Product products = (Product) objectInputStream.readObject();
            System.out.println(products.toString());
            objectInputStream.close();
        } catch(
    Exception e)

    {
        e.printStackTrace();
    }

}

    public static void main(String[] args) {
        readObject();
    }
}
