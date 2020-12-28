package models;

public class Employee {
    private String nameEmployee;
    private int ageEmployee;
    private String addressEmployee;

    public Employee(String nameEmployee, int ageEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return "Tên nhân viên: " + nameEmployee +
                " , Tuổi: " + ageEmployee +
                " , Địa chỉ: " + addressEmployee;
    }
}
