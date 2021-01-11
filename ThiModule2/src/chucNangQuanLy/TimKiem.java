package chucNangQuanLy;

import common.CheckClass;
import common.DocGhiFile;
import mainController.MobilePhoneController;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TimKiem {
    public static void timKiem() throws IOException {
        System.out.println("Nhập id muốn tìm kiếm");

        Scanner scanner = new Scanner(System.in);
        List<String> listDienThoai = DocGhiFile.readFile("src/data/DienThoai.csv");
        boolean flag;

        int chooseId = scanner.nextInt();

        int index = 0;
        for (index = 0; index < listDienThoai.size(); index++) {
            String[] array = listDienThoai.get(index).split(",");
            if (chooseId == Integer.parseInt(array[0])) {
                System.out.println("Tên điện thoại: " + array[1] +
                        ", Giá bán: " + array[2] +
                        ", Số lượng: " + array[3] +
                        ", Năm sản xuất: " + array[4]);
                        MobilePhoneController.displayMenu();
                        break;
            }
        }
        if(index == listDienThoai.size()){
            System.out.println("Không tìm thấy ID");
            MobilePhoneController.displayMenu();
        }
    }
}
