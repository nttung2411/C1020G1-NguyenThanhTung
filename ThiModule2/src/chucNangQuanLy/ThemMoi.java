package chucNangQuanLy;

import common.CheckClass;
import common.DocGhiFile;
import common.Validate;
import mainController.MobilePhoneController;
import mobilePhone.DienThoaiChinhHang;
import mobilePhone.DienThoaiXachTay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThemMoi {
    public static void themMoi() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        List<String> listDienThoai = DocGhiFile.readFile("src/data/DienThoai.csv");
        System.out.println("1.Thêm điện thoại chính hãng \n" +
                "2.Thêm điện thoại xách tay \n" +
                "3.Trở về Menu \n" +
                "4.Thoát chương trình");

        int chooseNumber = CheckClass.checkNumber(4);

        switch (chooseNumber) {
            case 1:
                System.out.println("Nhập tên điện thoại:");
                int idDienThoaiChinhHang;
                String tenDienThoaiChinhHang;
                double giaDienThoaiChinhHang;
                int soLuongDienThoaiChinhHang;
                int thoiGianBaoHanh;
                String phamViBaoHanh;
                String nhaSanXuatChinhHang;
                do {
                    flag = true;
                    tenDienThoaiChinhHang = scanner.nextLine();
                    if (!Validate.validateNameMobile(tenDienThoaiChinhHang)) {
                        System.out.println("Chữ cái đầu viét hoa , không được chứa số !");
                        flag = false;
                    }
                } while (!flag);

                giaDienThoaiChinhHang = CheckClass.checkPrice();

                soLuongDienThoaiChinhHang = CheckClass.checkSoLuong();

                System.out.println("Nhập nhà sản xuất: ");
                do {
                    flag = true;
                    nhaSanXuatChinhHang = scanner.nextLine();
                    if (!Validate.validateNameMobile(nhaSanXuatChinhHang)) {
                        System.out.println("Chữ cái đầu viét hoa , không được chứa số !");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Nhập thời gian bảo hành: ");
                thoiGianBaoHanh = CheckClass.checkNumber(730);

                System.out.println("Phạm vi bảo hành: ");
                do {
                    flag = true;
                    phamViBaoHanh = scanner.nextLine();
                    if (!Validate.validatePhamViBaoHanh(phamViBaoHanh)) {
                        System.out.println("Chọn 'Toan Quoc' hoặc 'Quoc Te'");
                        flag = false;
                    }
                } while (!flag);

                if (listDienThoai.size() == 0) {
                    idDienThoaiChinhHang = 1;
                } else {
                    String[] array = listDienThoai.get(listDienThoai.size() - 1).split(",");
                    idDienThoaiChinhHang = Integer.parseInt(array[0]) + 1;
                }
                DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(idDienThoaiChinhHang, tenDienThoaiChinhHang, giaDienThoaiChinhHang, soLuongDienThoaiChinhHang
                        , nhaSanXuatChinhHang, thoiGianBaoHanh, phamViBaoHanh);

                DocGhiFile.writeFile("src/data/DienThoai.csv",dienThoaiChinhHang.toString());
                DocGhiFile.writeFile("src/data/DienThoaiChinhHang.csv",dienThoaiChinhHang.toString());
                MobilePhoneController.displayMenu();
                break;

            case 2:
                System.out.println("Nhập tên điện thoại:");
                int idDienThoai;
                String tenDienThoaiXachTay;
                double giaDienThoaiXachTay;
                int soLuongDienThoaiXachTay;
                String quocGiaXachTay;
                String trangThai;
                String nhaSanXuat;
                do {
                    flag = true;
                    tenDienThoaiXachTay = scanner.nextLine();
                    if (!Validate.validateNameMobile(tenDienThoaiXachTay)) {
                        System.out.println("Chữ cái đầu viét hoa , không được chứa số !");
                        flag = false;
                    }
                } while (!flag);

                giaDienThoaiXachTay = CheckClass.checkPrice();

                soLuongDienThoaiXachTay = CheckClass.checkSoLuong();

                System.out.println("Nhập nhà sản xuất: ");
                do {
                    flag = true;
                    nhaSanXuat = scanner.nextLine();
                    if (!Validate.validateNameMobile(nhaSanXuat)) {
                        System.out.println("Chữ cái đầu viét hoa , không được chứa số !");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Nhập quốc gia xách tay");
                do{
                    flag = true;
                    quocGiaXachTay = scanner.nextLine();
                    if(!Validate.validateQuocGia(quocGiaXachTay)){
                        System.out.println("Quốc gia phải là 'Nhat Ban' , 'Han Quoc' , 'My' hoặc 'Trung Quoc'");
                        flag = false;
                    }
                }while (!flag);

                System.out.println("Trạng thái: ");
                do {
                    flag = true;
                    trangThai = scanner.nextLine();
                    if (!Validate.validateTrangThai(trangThai)) {
                        System.out.println("Chọn 'Da sua chua' hoặc 'Chua sua chua'");
                        flag = false;
                    }
                } while (!flag);

                if (listDienThoai.size() == 0) {
                    idDienThoai = 1;
                } else {
                    String[] array = listDienThoai.get(listDienThoai.size() - 1).split(",");
                    idDienThoai = Integer.parseInt(array[0]) + 1;
                }
                DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(idDienThoai, tenDienThoaiXachTay, giaDienThoaiXachTay, soLuongDienThoaiXachTay
                        , nhaSanXuat, quocGiaXachTay,trangThai);

                DocGhiFile.writeFile("src/data/DienThoai.csv",dienThoaiXachTay.toString());
                DocGhiFile.writeFile("src/data/DienThoaiXachTay.csv",dienThoaiXachTay.toString());
                MobilePhoneController.displayMenu();
                break;

            case 3:
                MobilePhoneController.displayMenu();
                break;
            default:
                break;
        }
    }
}
