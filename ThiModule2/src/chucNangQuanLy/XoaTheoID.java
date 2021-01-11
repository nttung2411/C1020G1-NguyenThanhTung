package chucNangQuanLy;

import common.DocGhiFile;
import mainController.MobilePhoneController;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class XoaTheoID {
    public static void xoaDienThoai() throws IOException {
        System.out.println("Nhập ID muốn xoá");
        Scanner scanner = new Scanner(System.in);
        List<String> listDienThoai = DocGhiFile.readFile("src/data/DienThoai.csv");
        boolean flag;
        int chooseId = 0;
        do {
            try {
                flag = true;
                chooseId = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Không được nhập chữ");
                scanner.nextLine();
                flag = false;
            }
            if (listDienThoai.size() == 0) {
                System.out.println("Chưa có điện thoại trong danh sách");
                flag = false;
            } else {
                int index;
                for (index = 0; index < listDienThoai.size(); index++) {
                    String[] array = listDienThoai.get(index).split(",");
                    if (chooseId == Integer.parseInt(array[0])) {
                        System.out.println("Bạn có muốn xoá hay không");
                        do {
                            String choose = scanner.nextLine();
                            if (choose.equals("Yes")) {
                                listDienThoai.remove(index);
                                flag = true;
                                DocGhiFile.writeUpdate(listDienThoai);
                                MobilePhoneController.displayMenu();
                                break;
                            } else if (choose.equals("No")) {
                                MobilePhoneController.displayMenu();
                                break;
                            } else {
                                flag = false;
                            }
                        } while (!flag);
                    }
                }
            }
        }   while (!flag) ;
    }
}
