package chucNangQuanLy;

import common.CheckClass;
import common.DocGhiFile;
import mainController.MobilePhoneController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HienThiDanhSach {
    public static void hienThiDanhSach() throws IOException {
        System.out.println("1.Show điện thoại chính hãng \n" +
                "2.Show diện thoại xách tay \n" +
                "3.Trở về Menu");
        int chooseNumber = CheckClass.checkNumber(3);
        switch (chooseNumber) {
            case 1:
                List<String> listDienThoaiChinhHang = DocGhiFile.readFile("src/data/DienThoaiChinhHang.csv");
                if (listDienThoaiChinhHang.size() > 0) {
                    for (int index = 0; index < listDienThoaiChinhHang.size(); index++) {
                        String[] array = listDienThoaiChinhHang.get(index).split(",");
                        System.out.println("ID điện thoại: " + array[0] +
                                ", Tên điện thoại: " + array[1] +
                                ", Giá bán: " + array[2] +
                                ", Số lượng: " + array[3] +
                                ", Năm sản xuất: " + array[4] +
                                ", Thời gian bảo hành: " + array[5] +
                                ", Phạm vi bảo hành: " + array[6]);
                    }
                    MobilePhoneController.displayMenu();
                } else {
                    System.out.println("Chưa có điện thoại chính hãng");
                    MobilePhoneController.displayMenu();
                }
                break;
            case 2:
                List<String> listDienThoaiXachTay = DocGhiFile.readFile("src/data/DienThoaiXachTay.csv");
                if (listDienThoaiXachTay.size() > 0) {
                    for (int index = 0; index < listDienThoaiXachTay.size(); index++) {
                        String[] array = listDienThoaiXachTay.get(index).split(",");
                        System.out.println("ID điện thoại: " + array[0] +
                                ", Tên điện thoại: " + array[1] +
                                ", Giá bán: " + array[2] +
                                ", Số lượng: " + array[3] +
                                ", Năm sản xuất: " + array[4] +
                                ", Thời gian bảo hành: " + array[5] +
                                ", Phạm vi bảo hành: " + array[6]);
                    }
                    MobilePhoneController.displayMenu();
                } else {
                    System.out.println("Chưa có điện thoại xách tay");
                    MobilePhoneController.displayMenu();
                }
                break;
            case 3:
                MobilePhoneController.displayMenu();
                break;
        }
    }
}
