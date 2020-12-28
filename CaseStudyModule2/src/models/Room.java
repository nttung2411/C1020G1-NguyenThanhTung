package models;

import javax.jws.soap.SOAPBinding;

public class Room extends Services {

    private String freeService;

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String nameOfService, double areaOfService, double priceOfService, int accompanyPeople, String typeOfRental, String freeService) {
        super.id = id;
        super.nameOfService = nameOfService;
        super.areaOfService = areaOfService;
        super.priceOfService = priceOfService;
        super.accompanyPeople = accompanyPeople;
        super.typeOfRental = typeOfRental;
        this.freeService = freeService;
    }


    @Override
    public void showInfo() {
        System.out.println("ID Villa: " + getId() +
                " , Tên Villa: " + getNameOfService() +
                " , Diện tích: " + getAreaOfService() + "m2" +
                " , Số người tối đa: " + getAccompanyPeople() +
                " , Dịch vụ miễn phí: " + getFreeService() +
                " , Kiểu thuê: " + getTypeOfRental() +
                " , Chi phí thuê: " + getPriceOfService());
    }

    @Override
    public String toString() {
        return getId() + "," +
                getNameOfService() + "," +
                getAreaOfService() + "," +
                getPriceOfService() + "," +
                getAccompanyPeople() + "," +
                getTypeOfRental()  + "," +
                getFreeService();
    }
}
