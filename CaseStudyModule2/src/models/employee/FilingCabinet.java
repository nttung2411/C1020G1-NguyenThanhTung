package models.employee;

import common.FileUtils;
import controllers.MainController;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class FilingCabinet {
    public static void searchEmployee() throws IOException {
        Stack<String> employeesCabinet = FileUtils.readFileEmployee();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        System.out.println("Nhập ID nhân viên muốn tìm kiếm !");
        String employeeID = scanner.nextLine();
        for (String employee : employeesCabinet) {
            String[] array = employee.split(",");
            if (employeeID.equals(array[0])) {
                System.out.println("Tên nhân viên:" + array[1] +
                        " , Tuổi: " + array[2] +
                        " , Đia chỉ: " + array[3]);
                flag = true;
                break;
            }
        }
        if(flag = false){
            System.out.println("Không tìm thấy ID nhân viên");
        }
        MainController.displayMainMenu();
    }
}
