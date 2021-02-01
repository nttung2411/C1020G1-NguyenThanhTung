package model.service;

import model.bean.Customer;
import model.bean.Employee;
import model.repo.FuramaRepository;
import model.repo.FuramaRepositoryImpl;

import java.util.List;

public class FuramaServiceImpl implements  FuramaService {

    FuramaRepository furamaRepository = new FuramaRepositoryImpl();

    @Override
    public List<Customer> FindAllCustomer() {
       return furamaRepository.FindAllCustomer();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return furamaRepository.findAllEmployee();
    }

    @Override
    public Customer selectCustomerById(int id) {
        return furamaRepository.selectCustomerById(id);
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return furamaRepository.selectEmployeeById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        furamaRepository.updateCustomer(customer);
    }

    @Override
    public void updateEmployee(Employee employee) {
        furamaRepository.updateEmployee(employee);
    }

    @Override
    public void deleteCustomer(int id,String access) {
        if(access.equals("yes")){
            furamaRepository.deleteCustomer(id);
        }
    }

    @Override
    public void deleteEmployee(int id,String access) {
        if(access.equals("yes")){
            furamaRepository.deleteEmployee(id);
        }
    }


    @Override
    public List<Customer> searchCustomer(String name) {
        return furamaRepository.searchCustomer(name);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        return furamaRepository.searchEmployee(name);
    }

    @Override
    public void addCustomer(Customer customer) {
        furamaRepository.addCustomer(customer);
    }

    @Override
    public void addEmployee(Employee employee) {
        furamaRepository.addEmployee(employee);
    }
}
