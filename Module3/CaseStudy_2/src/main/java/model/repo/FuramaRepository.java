package model.repo;

import model.bean.Customer;
import model.bean.Employee;

import java.util.List;

public interface FuramaRepository {
    List<Customer> FindAllCustomer();

    Customer selectCustomerById(int id);

    Employee selectEmployeeById(int id);

    void updateCustomer(Customer customer);

    void updateEmployee(Employee employee);

    void deleteCustomer(int id);

    void deleteEmployee(int id);

    List<Customer> searchCustomer(String name);

    List<Employee> searchEmployee(String name);

    List<Employee> findAllEmployee();

    void addCustomer(Customer customer);

    void addEmployee(Employee employee);
}
