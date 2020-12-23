package models;

public class House extends Services {

    private String typeOfRoom;
    private int floors;

    public House(String id, String nameOfService, double areaOfService, double priceOfService, int accompanyPeople, String typeOfRental,String typeOfRoom, int floors) {
        super.id = id;
        super.nameOfService = nameOfService;
        super.areaOfService = areaOfService;
        super.priceOfService = priceOfService;
        super.accompanyPeople = accompanyPeople;
        super.typeOfRental = typeOfRental;
        this.typeOfRoom = typeOfRoom;
        this.floors = floors;
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

    @Override
    public void showInfo() {
        System.out.println("ID House: " + getId() +
                " , Tên House: " + getNameOfService() +
                " , Diện tích: " + getAreaOfService() + "m2" +
                " , Số người tối đa: " + getAccompanyPeople() +
                " , Số tầng: " + getFloors() +
                " , Tiêu chuẩn phòng: " + getTypeOfRoom() +
                " , Kiểu thuê: " + getTypeOfRental() +
                " , Chi phí thuê: " + getPriceOfService());
    }

    @Override
    public String toString() {
         return getId() + "," +
                getNameOfService() + "," +
                getAreaOfService() + "," +
                getAccompanyPeople() + "," +
                getFloors() + "," +
                getTypeOfRoom() + "," +
                getTypeOfRental() + "," +
                getPriceOfService();
    }
}
