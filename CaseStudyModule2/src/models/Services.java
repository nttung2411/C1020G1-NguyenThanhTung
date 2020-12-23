package models;

public abstract class Services {
    String id;

    String nameOfService;
    double areaOfService;
    double priceOfService;
    int accompanyPeople;
    String typeOfRental;


    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getAreaOfService() {
        return areaOfService;
    }

    public void setAreaOfService(double areaOfService) {
        this.areaOfService = areaOfService;
    }

    public double getPriceOfService() {
        return priceOfService;
    }

    public void setPriceOfService(double priceOfService) {
        this.priceOfService = priceOfService;
    }

    public int getAccompanyPeople() {
        return accompanyPeople;
    }

    public void setAccompanyPeople(int accompanyPeople) {
        this.accompanyPeople = accompanyPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    public String getId() {
        return id;
    }


    abstract void showInfo();

}
