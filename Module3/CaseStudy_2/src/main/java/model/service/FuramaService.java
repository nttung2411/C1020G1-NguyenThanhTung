package model.service;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface FuramaService {
    List<Customer> FindAllCustomer();

    List<Employee> findAllEmployee();

    Customer selectCustomerById(int id);

    Employee selectEmployeeById(int id);

    void updateCustomer(Customer customer);

    void updateEmployee(Employee employee);

    void deleteCustomer(int id,String access);

    void deleteEmployee(int id,String access);

    List<Customer> searchCustomer(String name);

    List<Employee> searchEmployee(String name);

    void addCustomer(Customer customer);

    void addEmployee(Employee employee);
}
