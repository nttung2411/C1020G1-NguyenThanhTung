package mainController;

import chucNangQuanLy.HienThiDanhSach;
import chucNangQuanLy.ThemMoi;
import chucNangQuanLy.TimKiem;
import chucNangQuanLy.XoaTheoID;
import common.CheckClass;

import java.io.IOException;
import java.util.Scanner;

public class MobilePhoneController {
    public static void displayMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn chức năng theo số (để tiếp tục): \n" +
                            "1.Thêm mới \n" +
                            "2.Xoá \n" +
                            "3.Xem danh sách điện thoại \n" +
                            "4.Tìm kiếm \n" +
                            "5.Thoát \n"+
                            "Chọn chức năng:");

        int chooseNumber = CheckClass.checkNumber(5);
        switch (chooseNumber){
            case 1:
                ThemMoi.themMoi();
                break;
            case 2:
                XoaTheoID.xoaDienThoai();
                break;
            case 3:
                HienThiDanhSach.hienThiDanhSach();
                break;
            case 4:
                TimKiem.timKiem();
                break;
            case 5:
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        displayMenu();
    }
}
