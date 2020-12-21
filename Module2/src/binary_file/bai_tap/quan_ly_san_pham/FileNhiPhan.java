package binary_file.bai_tap.quan_ly_san_pham;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileNhiPhan {
    public static void main(String[] args) throws IOException {
        File file = new File("src/binary_file/bai_tap/quan_ly_san_pham/ListSanPham.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Reader reader = new InputStreamReader(fileInputStream, "UTF8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;


        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Thêm sản phẩm \n" +
                "2.Hiển thị sản phẩm \n" +
                "3.Tìm kiếm sản phẩm");

        int inputNumber = 0;
        try {
            do {
                System.out.print("Nhập số có trong menu:");
                inputNumber = scanner.nextInt();
            } while (inputNumber < 1 || inputNumber > 3);
        } catch (Exception e) {
            System.err.println("Nhập sai , vui lòng chạy lại chương trình");
            scanner.nextLine();
        }

        switch (inputNumber) {
            case 1:
                System.out.println("Tên sản phẩm mới: ");
                String newNameProduct = scanner.next();
                System.out.println("Mã sản phẩm:");
                String newIdProduct = scanner.next();
                System.out.println("Hãng sản xuất:");
                String newManufacturerProduct = scanner.next();
                System.out.println("Giá sản phẩm:");
                int newPriceProDuct = scanner.nextInt();
                Product product = new Product(newIdProduct, newNameProduct, newManufacturerProduct, newPriceProDuct);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    Writer out = new OutputStreamWriter(fileOutputStream, "UTF8");
                    out.write(product.getIdProduct() + "," + product.getNameProduct() + "," + product.getManufacturerProduct() + "," + product.getPriceProduct() + '\n');
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                while ((line = bufferedReader.readLine()) != null) {
                    String[] array = line.split(",");
                    System.out.println("ID sản phẩm:" + array[0]
                            + " , Tên sản phẩm:" + array[1]
                            + " , Hãng sản xuất:" + array[2]
                            + " , Giá:" + array[3]);
                }
                break;
            case 3:
                boolean flag = true;
                System.out.println("Nhập ID sản phẩm muốn tìm");
                String inputIDProduct = scanner.next();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] array = line.split(",");
                    if (inputIDProduct.equals(array[0])) {
                        System.out.println("ID sản phẩm:" + array[0]
                                + " , Tên sản phẩm:" + array[1]
                                + " , Hãng sản xuất:" + array[2]
                                + " , Giá:" + array[3]);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    System.out.println("Không tìm thấy iD");
                }
                break;
        }
    }
}