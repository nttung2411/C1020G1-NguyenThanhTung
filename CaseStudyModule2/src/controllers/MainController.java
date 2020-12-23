package controllers;

import models.House;
import models.Room;
import models.ValidateService;
import models.Villa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);


    public static void displayMainMenu() throws IOException {
        System.out.println("1.Add New Service \n"
                + "2.Show Services \n"
                + "3.Add New Customer \n"
                + "4.Show Information of Customer \n"
                + "5.Add New Booking"
                + "6.Show Information of Employee \n"
                + "7.Exit");

        int chooseNumber = CheckClass.checkNumber(7);
        switch (chooseNumber) {
            case 1:
                addNewService();
                break;
            case 2:
                ShowService.showService();
                break;
        }
    }


    public static void addNewService() throws IOException {
        System.out.println("1.Add New Villa \n"
                + "2.Add New House \n"
                + "3.Add New Room \n"
                + "4.Back to menu \n"
                + "5.Exit");
        int inputNumberService = CheckClass.checkNumber(5);

        switch (inputNumberService) {

            case 1:
                ValidateService validateService = new ValidateService();
                List<String> checkIDVilla = FileUtils.readFile("Villa.csv");
                boolean flag;
                String idVilla;
                String nameVilla;
                double areaOfVilla;
                double areaPoolVilla;
                int floorsOfVilla;
                int accompanyPeople;
                double priceVilla;
                String typeOfRental;
                String typeOfRoomVilla;

                System.out.println("ID Villa muốn tạo(ví dụ SVVL-YYYY (Y là số 0-9): ");

                do {
                    flag = true;
                    idVilla = scanner.nextLine();
                    if (!validateService.validateIdVilla(idVilla)) {
                        System.out.println("Nhập đúng định dạng SVVL-YYYY (Y là số 0-9)");
                        flag = false;
                    }

                    for (int index = 0; index < checkIDVilla.size(); index++) {
                        String[] arrayVilla = checkIDVilla.get(index).split(",");
                        if (arrayVilla[0].equals(idVilla)) {
                            System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                            flag = false;
                        }
                    }
                } while (!flag);

                System.out.println("Tên Villa: ");

                do {
                    flag = true;
                    nameVilla = scanner.nextLine();
                    if (!validateService.validateNameService(nameVilla)) {
                        System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Diện tích Villa: ");

                do {
                    flag = true;
                    areaOfVilla = scanner.nextDouble();
                    if (areaOfVilla < 30 || areaOfVilla > 1000) {
                        System.out.println("Diện tích Villa phải lớn hơn 30m2 và nhỏ hơn 1000m2");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Diện tích hồ bơi: ");

                do {
                    flag = true;
                    areaPoolVilla = scanner.nextDouble();
                    if (areaPoolVilla < 10 || areaPoolVilla > 100) {
                        System.out.println("Diện tích Villa phải lớn hơn 10m2 và nhỏ hơn 100m2");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Số tầng Villa: ");
                floorsOfVilla = CheckClass.checkNumber(5);

                System.out.println("Kiểu cho thuê: ");
                do {
                    typeOfRental = scanner.nextLine();
                    flag = CheckClass.checkTypeRental(typeOfRental);
                } while (!flag);

                System.out.println("Loại phòng: ");
                do {
                    typeOfRoomVilla = scanner.nextLine();
                    flag = CheckClass.checkTypeRoom(typeOfRoomVilla);
                } while (!flag);

                System.out.println("Sức chứa villa: ");
                accompanyPeople = CheckClass.checkNumber(30);

                priceVilla = CheckClass.checkPrice();
                Villa villa = new Villa(idVilla, nameVilla, areaOfVilla, accompanyPeople, floorsOfVilla, typeOfRoomVilla, areaPoolVilla, typeOfRental,priceVilla);
                FileUtils.writeFile("Villa.csv", villa);
                break;
            case 2:
                List<String> checkIDHouse = FileUtils.readFile("House.csv");
                ValidateService validateServiceHouse = new ValidateService();
                String idHouse;
                String nameHouse;
                double areaOfHouse;
                int floorsOfHouse;
                int accompanyPeopleHouse;
                double priceHouse;
                String typeOfRentalHouse;
                String typeOfRoomHouse;

                System.out.println("ID House muốn tạo(ví dụ SVHO-YYYY (Y là số 0-9): ");

                do {
                    flag = true;
                    idHouse = scanner.nextLine();
                    if (!validateServiceHouse.validateIdHouse(idHouse)) {
                        System.out.println("Nhập đúng định dạng SVHO-YYYY (Y là số 0-9)");
                        flag = false;
                    }

                    for (int index = 0; index < checkIDHouse.size(); index++) {
                        String[] arrayVilla = checkIDHouse.get(index).split(",");
                        if (arrayVilla[0].equals(idHouse)) {
                            System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                            flag = false;
                        }
                    }
                } while (!flag);

                System.out.println("Tên House: ");

                do {
                    flag = true;
                    nameHouse = scanner.nextLine();
                    if (!validateServiceHouse.validateNameService(nameHouse)) {
                        System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Diện tích House: ");

                do {
                    flag = true;
                    areaOfHouse = scanner.nextDouble();
                    if (areaOfHouse < 30 || areaOfHouse > 400) {
                        System.out.println("Diện tích House phải lớn hơn 30m2 và nhỏ hơn 400m2");
                        flag = false;
                    }
                } while (!flag);


                System.out.println("Số tầng House: ");
                floorsOfHouse = CheckClass.checkNumber(5);

                System.out.println("Kiểu cho thuê: ");
                do {
                    typeOfRentalHouse = scanner.nextLine();
                    flag = CheckClass.checkTypeRental(typeOfRentalHouse);
                } while (!flag);

                System.out.println("Loại phòng: ");
                do {
                    typeOfRoomHouse = scanner.nextLine();
                    flag = CheckClass.checkTypeRoom(typeOfRoomHouse);
                } while (!flag);

                System.out.println("Sức chứa House: ");
                accompanyPeopleHouse = CheckClass.checkNumber(30);

                priceHouse = CheckClass.checkPrice();
                House house = new House(idHouse, nameHouse, areaOfHouse, priceHouse, accompanyPeopleHouse, typeOfRentalHouse, typeOfRoomHouse, floorsOfHouse);
                FileUtils.writeFile("House.csv", house);
                break;
            case 3:
                List<String> checkIDRoom = FileUtils.readFile("Room.csv");
                ValidateService validateServiceRoom = new ValidateService();
                String idRoom;
                String nameRoom;
                double areaOfRoom;
                int accompanyPeopleRoom;
                double priceRoom;
                String typeOfRentalRoom;
                String freeService;

                System.out.println("ID Room muốn tạo(ví dụ SVRO-YYYY (Y là số 0-9): ");

                do {
                    flag = true;
                    idRoom = scanner.nextLine();
                    if (!validateServiceRoom.validateIdRoom(idRoom)) {
                        System.out.println("Nhập đúng định dạng SVRO-YYYY (Y là số 0-9)");
                        flag = false;
                    }

                    for (int index = 0; index < checkIDRoom.size(); index++) {
                        String[] arrayVilla = checkIDRoom.get(index).split(",");
                        if (arrayVilla[0].equals(idRoom)) {
                            System.out.println("ID đã tồn tại , vui lòng nhập lại ID!");
                            flag = false;
                        }
                    }
                } while (!flag);

                System.out.println("Tên Room: ");

                do {
                    flag = true;
                    nameRoom = scanner.nextLine();
                    if (!validateServiceRoom.validateNameService(nameRoom)) {
                        System.out.println("Chữ cái đầu phải viết hoa , chỉ chứa ký tự bình thường!");
                        flag = false;
                    }
                } while (!flag);

                System.out.println("Diện tích Room: ");

                do {
                    flag = true;
                    areaOfRoom = scanner.nextDouble();
                    if (areaOfRoom < 30 || areaOfRoom > 150) {
                        System.out.println("Diện tích House phải lớn hơn 30m2 và nhỏ hơn 150m2");
                        flag = false;
                    }
                } while (!flag);


                System.out.println("Kiểu cho thuê: ");
                do {
                    typeOfRentalRoom = scanner.nextLine();
                    flag = CheckClass.checkTypeRental(typeOfRentalRoom);
                } while (!flag);


                System.out.println("Sức chứa Room: ");
                accompanyPeopleRoom = CheckClass.checkNumber(7);

                System.out.println("Dịch vụ miễn phí(Ăn sáng hoặc ăn tối): ");
                do {
                    freeService = scanner.nextLine();
                    if (freeService.equals("Ăn sáng") || freeService.equals("Ăn tối")) {
                        flag = true;
                    } else {
                        System.out.println("Chọn miễn phí bửa sáng hoặc tối");
                        flag = false;
                    }
                } while (!flag);

                priceRoom = CheckClass.checkPrice();

                Room room = new Room(idRoom, nameRoom, areaOfRoom, priceRoom, accompanyPeopleRoom, typeOfRentalRoom,freeService);
                FileUtils.writeFile("House.csv", room);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        displayMainMenu();
    }
}
