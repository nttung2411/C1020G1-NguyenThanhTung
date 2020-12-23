package models;

public class Villa extends Services {

    private String typeOfRoom;
    private int floors;
    private double areaOfPool;


    public Villa(String id, String nameOfService, double areaOfService, int accompanyPeople, int floors,String typeOfRoom,double areaOfPool , String typeOfRental,double priceOfService) {
        super.id = id;
        super.nameOfService = nameOfService;
        super.areaOfService = areaOfService;
        super.priceOfService = priceOfService;
        super.accompanyPeople = accompanyPeople;
        super.typeOfRental = typeOfRental;
        this.floors = floors;
        this.areaOfPool = areaOfPool;
        this.typeOfRoom = typeOfRoom;
    }


    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    @Override
    public void showInfo() {
        System.out.println("ID Villa: " + getId() +
                " , Tên Villa: " + getNameOfService() +
                " , Diện tích: " + getAreaOfService() + "m2" +
                " , Số người tối đa: " + getAccompanyPeople() +
                " , Số tầng: " + getFloors() +
                " , Tiêu chuẩn phòng: " + getTypeOfRoom() +
                " , Diện tích hồ bơi: " + getAreaOfPool() +
                " , Kiểu thuê: " + getTypeOfRental() +
                " , Chi phí thuê: " + getPriceOfService() + "USD");
    }

    @Override
    public String toString() {
        return getId() + "," +
                getNameOfService() + "," +
                getAreaOfService() + "," +
                getAccompanyPeople() + "," +
                getFloors() + "," +
                getTypeOfRoom() + "," +
                getAreaOfPool() + "," +
                getTypeOfRental() + "," +
                getPriceOfService();
    }
}