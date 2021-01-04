package models.employee;

import models.customer.Customer;

public class Employee {
    private String nameEmployee;
    private int ageEmployee;
    private String addressEmployee;
    private String idEmployee;

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
