package controllers;

import common.CheckClass;
import common.FileUtils;
import models.*;
import models.customer.CustomerManager;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);


    public static void displayMainMenu() throws IOException, ClassNotFoundException {
        System.out.println("1.Add New Service \n"
                + "2.Show Services. \n"
                + "3.Add New Customer. \n"
                + "4.Show Information of Customer. \n"
                + "5.Add New Booking. \n"
                + "6.Show Information of Employee. \n"
                + "7.Cinemas Booking. \n"
                + "8.Exit.");

        int chooseNumber = CheckClass.checkNumber(8);
        switch (chooseNumber) {
            case 1:
                ServiceManager.addNewService();
                break;
            case 2:
                ServiceManager.showService();
                break;
            case 3:
                CustomerManager.addNewCustomer();
                break;
            case 4:
                CustomerManager.showInformationCustomer();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                EmployeeController.showEmployee();
                break;
            case 7:
                Cinemas.bookingCinemas();
            default:
                break;
        }
    }


    public static void addNewBooking() throws IOException, ClassNotFoundException {
        System.out.println("1.Danh sách Customer Booking \n" +
                "2.Back to Menu \n" +
                "3.Exit");
        int chooseNumber = CheckClass.checkNumber(3);

        switch (chooseNumber) {
            case 1:
                List<String> listNameCustomer = FileUtils.readFile("src/data/Customer.csv");
                int count = 1;
                String idBookingCustomer = null;

                if (listNameCustomer.size() > 0) {

                    for (int index = 0; index < listNameCustomer.size(); index++) {
                        String[] array = listNameCustomer.get(index).split(",");
                        System.out.println(count + ". Tên Customer: " + array[0] +
                                " , ID: " + array[3]);
                        count++;
                    }
                    int chooseCustomerNumber = CheckClass.checkNumber(count - 1);
                    String[] arrayChooseCustomer = listNameCustomer.get(chooseCustomerNumber - 1).split(",");
                    idBookingCustomer = arrayChooseCustomer[3];
                } else {
                    System.out.println("------------------------------------------");
                    System.out.println("Chưa có Customer , vui lòng thêm Customer");
                    System.out.println("------------------------------------------");
                    displayMainMenu();
                }

                System.out.println("1.Booking Villa \n" +
                        "2.Booking House \n" +
                        "3.Booking Room");
                int chooseBooking = CheckClass.checkNumber(3);
                switch (chooseBooking) {
                    case 1:
                        int countVilla = 1;
                        List<String> listVilla = FileUtils.readFile("src/data/Villa.csv");
                        if (listVilla.size() > 0) {
                            for (String elementVilla : listVilla) {
                                String[] villaArray = elementVilla.split(",");
                                Villa villa = new Villa(villaArray[0], villaArray[1], Double.parseDouble(villaArray[2]), Integer.parseInt(villaArray[3]), Integer.parseInt(villaArray[4]), villaArray[5], Double.parseDouble(villaArray[6]), villaArray[7], Double.parseDouble(villaArray[8]));
                                System.out.print(countVilla + " ");
                                villa.showInfo();
                                countVilla++;
                            }
                            int chooseVilla = CheckClass.checkNumber(countVilla - 1);
                            String[] array = listVilla.get(chooseVilla - 1).split(",");
                            String idBooking = idBookingCustomer + "," + array[0];
                            FileUtils.writeFileBooking("src/data/Booking.csv", (idBooking));
                            displayMainMenu();
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("Hiện chưa có Villa nào trong danh sách!");
                            System.out.println("----------------------------------------");
                            displayMainMenu();
                        }
                        break;
                    case 2:
                        int countHouse = 1;
                        List<String> listHouse = FileUtils.readFile("src/data/House.csv");
                        if (listHouse.size() > 0) {
                            for (String elementHouse : listHouse) {
                                String[] houseArray = elementHouse.split(",");
                                House house = new House(houseArray[0], houseArray[1], Double.parseDouble(houseArray[2]), Integer.parseInt(houseArray[3]), Integer.parseInt(houseArray[4]), houseArray[5], houseArray[6], Double.parseDouble(houseArray[7]));
                                System.out.println(countHouse + " ");
                                house.showInfo();
                                countHouse++;
                                int chooseHouse = CheckClass.checkNumber(countHouse - 1);
                                String[] arrayHouse = listHouse.get(chooseHouse - 1).split(",");
                                String idBookingHouse = idBookingCustomer + "," + arrayHouse[0];
                                FileUtils.writeFileBooking("src/data/Booking.csv", (idBookingHouse));
                                displayMainMenu();
                                break;
                            }
                        } else {
                            System.out.println("------------------------------------------");
                            System.out.println("Hiện chưa có House nào trong danh sách !!");
                            System.out.println("------------------------------------------");
                        }
                    case 3:
                        int countRoom = 1;
                        List<String> listRoom = FileUtils.readFile("src/data/House.csv");
                        if (listRoom.size() > 0) {
                            for (String elementRoom : listRoom) {
                                String[] roomArray = elementRoom.split(",");
                                Room room = new Room(roomArray[0], roomArray[1], Double.parseDouble(roomArray[2]), Double.parseDouble(roomArray[3]), Integer.parseInt(roomArray[4]), roomArray[5], roomArray[6]);
                                System.out.println(countRoom + " ");
                                room.showInfo();
                                countRoom++;
                                int chooseHouse = CheckClass.checkNumber(countRoom - 1);
                                String[] arrayHouse = listRoom.get(chooseHouse - 1).split(",");
                                String idBookingHouse = idBookingCustomer + "," + arrayHouse[0];
                                FileUtils.writeFileBooking("src/data/Booking.csv", (idBookingHouse));
                                displayMainMenu();
                                break;
                            }
                        } else {
                            System.out.println("------------------------------------------");
                            System.out.println("Hiện chưa có Room nào trong danh sách!!");
                            System.out.println("------------------------------------------");
                        }
                }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        displayMainMenu();
    }
}