package controllers;

import models.House;
import models.Room;
import models.Villa;

import java.io.IOException;
import java.util.List;

public class ShowService {
    public static void showService() throws IOException {
        System.out.println("1. Show all Villa" + "\n"
                + "2. Show all House" + "\n"
                + "3. Show all Room" + "\n"
                + "4. Show all ID Villa Not Duplicate" + "\n"
                + "5. Show all ID House Not Duplicate" + "\n"
                + "6. Show all ID Room Not Duplicate" + "\n"
                + "7. Back to Menu"
                + "8. Exit");

        int chooseNumber = CheckClass.checkNumber(8);
        switch (chooseNumber) {
            case 1:
                List<String> listVilla = FileUtils.readFile("Villa.csv");
                for(String index : listVilla){
                    String[] villaArray = index.split(",");
                    Villa villa = new Villa(villaArray[0],villaArray[1],Double.parseDouble(villaArray[2]),Integer.parseInt(villaArray[3]),Integer.parseInt(villaArray[4]),villaArray[5],Double.parseDouble(villaArray[6]),villaArray[7],Double.parseDouble(villaArray[8]));
                    villa.showInfo();
                }
                break;
            case 2:
                List<String> listHouse = FileUtils.readFile("House.csv");
                for(String index : listHouse){
                    String[] houseArray = index.split(",");
                    House house = new House(houseArray[0],houseArray[1],Double.parseDouble(houseArray[2]),Integer.parseInt(houseArray[3]),Integer.parseInt(houseArray[4]),houseArray[5],houseArray[6],Integer.parseInt(houseArray[7]));
                    house.showInfo();
                }
                break;
            case 3:
                List<String> listRoom = FileUtils.readFile("Room.csv");
                for(String index : listRoom){
                    String[] roomArray = index.split(",");
                    Room room = new Room(roomArray[0],roomArray[1],Double.parseDouble(roomArray[2]),Double.parseDouble(roomArray[3]),Integer.parseInt(roomArray[4]),roomArray[5],roomArray[6]);
                    room.showInfo();
                }
        }
    }
}
