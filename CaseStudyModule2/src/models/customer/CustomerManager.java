package models.customer;

import common.CheckClass;
import common.FileUtils;
import common.ValidateCustomer;
import controllers.MainController;
import models.customer.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CustomerManager {
    public static void showInformationCustomer() throws IOException, ClassNotFoundException {
        List<String> listString = FileUtils.readFile("src/data/Customer.csv");
        Set<Customer> listCustomer = new TreeSet<>();
        for (int indexList = 0; indexList < listString.size(); indexList++) {
            String[] array = listString.get(indexList).split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
            listCustomer.add(customer);
        }

        for (Customer info : listCustomer) {
            System.out.println("Tên Customer: " + info.getNameCustomer() +
                    " , Ngày sinh: " + info.getDateOfBirth() +
                    " , CMND: " + info.getIdCustomer() +
                    " , Email: " + info.getEmailCustomer() +
                    " , Số điện thoại: " + info.getPhoneNumberCustomer() +
                    " , Địa chỉ: " + info.getAddressCustomer());
        }
        MainController.displayMainMenu();
    }


    public static void addNewCustomer() throws IOException, ClassNotFoundException {
        System.out.println("1.Thêm customer \n" +
                "2.Back về Menu \n" +
                "3.Exit");

        int chooseNumber = CheckClass.checkNumber(3);
        boolean flag;
        switch (chooseNumber){
            case 1:
                Scanner scanner = new Scanner(System.in);
                String nameCustomer;
                String birthDayCustomer;
                String genderCustomer;
                String idCardCustomer;
                String phoneNumberCustomer;
                String levelCardCustomer;
                String addressCustomer;
                String emailCustomer;

                System.out.println("Nhập tên Customer: ");
                do {
                    flag = true;
                    nameCustomer = scanner.nextLine();
                    if(!ValidateCustomer.validateName(nameCustomer)){
                        System.out.println("Tên phải đúng định dạng 'Nguyễn A'");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Ngày sinh:");
                do{
                    flag = true;
                    birthDayCustomer = scanner.nextLine();
                    if(!ValidateCustomer.validateBirthDay(birthDayCustomer)){
                        System.out.println("Theo định dạng dd/mm/yyyy , trên 18 tuổi , ngày tháng phải đúng thực tế!");
                        flag = false;
                    }
                }while (!flag);

                System.out.println("Giới tính (Male,Female,Unknown): ");
                do {
                    genderCustomer = scanner.nextLine();
                    flag = true;
                    if(ValidateCustomer.validateGender(genderCustomer) == null){
                        System.out.println("Lựa chọn male , female hoặc unknown!");
                        flag = false;
                    }else {
                        genderCustomer = ValidateCustomer.validateGender(genderCustomer);
                    }
                }while (!flag);



                System.out.println("Nhập CMND(Định dạng XXX-XXX-XXX):");
                do {
                    List<String> listIdCustomer = FileUtils.readFile("src/data/Customer.csv");
                    idCardCustomer = scanner.nextLine();
                    boolean validateId = ValidateCustomer.validateIdCard(idCardCustomer);
                    flag = true;
                    if(!validateId){
                        System.out.println("Đúng định dạng XXX-XXX-XXX(X là số)!!");
                        flag = false;
                    }

                    for(int index = 0 ; index < listIdCustomer.size() ; index ++){
                        String[] arrayIdCustomer = listIdCustomer.get(index).split(",");
                        if(arrayIdCustomer[3].equals(idCardCustomer)){
                            System.out.println("CMND đã bị trùng , vui lòng nhập lại !");
                            flag = false;
                        }
                    }
                }while (!flag);



                System.out.println("Nhập SĐT(Định dạng 0XXX-XXX-XXX)");
                do {
                    phoneNumberCustomer = scanner.nextLine();
                    flag = true;
                    if(!ValidateCustomer.validatePhoneNumber(phoneNumberCustomer)){
                        System.out.println("Đúng định dạng 0XXX-XXX-XXX(X là số)");
                        flag = false;
                    }
                }while (!flag);

                System.out.println("Nhập Email:");
                do {
                    emailCustomer = scanner.nextLine();
                    flag = true;
                    if(!ValidateCustomer.validateEmail(emailCustomer)){
                        System.out.println("Định dạng abc@abc.abc");
                        flag = false;
                    }
                }while (!flag);



                System.out.println("Thẻ thành viên:");
                do {
                    levelCardCustomer = scanner.nextLine();
                    flag = true;
                    if(ValidateCustomer.validateCardCustomer(levelCardCustomer) == null){
                        System.out.println("Lựa chọn Diamond , Platinum , Gold , Silver hoặc Member!");
                        flag = false;
                    }else {
                        levelCardCustomer = ValidateCustomer.validateCardCustomer(levelCardCustomer);
                    }
                }while (!flag);



                System.out.println("Địa chỉ:");
                addressCustomer = scanner.nextLine();

                Customer customer = new Customer(nameCustomer,birthDayCustomer,genderCustomer,idCardCustomer,phoneNumberCustomer,emailCustomer,levelCardCustomer,addressCustomer);
                FileUtils.writeFile("src/data/Customer.csv",customer.toString());
                MainController.displayMainMenu();
                break;
            case 2:
                MainController.displayMainMenu();
                break;
            case 3:
                break;
        }
    }

}
