package model.repo;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl implements FuramaRepository {

    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Customer> FindAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_all_customer()");

            ResultSet resultSet = callableStatement.executeQuery();

            Customer customer;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_id(resultSet.getInt("customer_id"));
                customer.setCustomer_type(resultSet.getInt("customer_type"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public Customer selectCustomerById(int id) {
        Customer customer = new Customer();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_customer_by_id(?)");
            callableStatement.setInt(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            customer.setCustomer_type(resultSet.getInt("customer_type"));
            customer.setCustomer_name(resultSet.getString("customer_name"));
            customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
            customer.setCustomer_gender(resultSet.getInt("customer_gender"));
            customer.setCustomer_phone(resultSet.getString("customer_phone"));
            customer.setCustomer_email(resultSet.getString("customer_email"));
            customer.setCustomer_address(resultSet.getString("customer_address"));
            customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Employee selectEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_employee_by_id(?)");
            callableStatement.setInt(1,id);

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            employee.setEmployee_position(resultSet.getInt("position_id"));
            employee.setEmployee_name(resultSet.getString("employee_name"));
            employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
            employee.setEmployee_gender(resultSet.getInt("employee_gender"));
            employee.setEmployee_phone(resultSet.getString("employee_phone"));
            employee.setEmployee_email(resultSet.getString("employee_email"));
            employee.setEmployee_address(resultSet.getString("employee_address"));
            employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
            employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }



    @Override
    public void updateCustomer(Customer customer) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1,customer.getCustomer_id());
            callableStatement.setString(2,customer.getCustomer_name());
            callableStatement.setInt(3,customer.getCustomer_type());
            callableStatement.setString(4,customer.getCustomer_birthday());
            callableStatement.setInt(5,customer.getCustomer_gender());
            callableStatement.setString(6,customer.getCustomer_id_card());
            callableStatement.setString(7,customer.getCustomer_phone());
            callableStatement.setString(8,customer.getCustomer_email());
            callableStatement.setString(9,customer.getCustomer_address());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call update_employee(?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setInt(1,employee.getEmployee_id());
            callableStatement.setString(2,employee.getEmployee_name());
            callableStatement.setInt(3,employee.getEmployee_position());
            callableStatement.setString(4,employee.getEmployee_birthday());
            callableStatement.setInt(5,employee.getEmployee_gender());
            callableStatement.setString(6,employee.getEmployee_id_card());
            callableStatement.setString(7,employee.getEmployee_phone());
            callableStatement.setString(8,employee.getEmployee_email());
            callableStatement.setString(9,employee.getEmployee_address());
            callableStatement.setDouble(10,employee.getEmployee_salary());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call delete_customer(?)");
            callableStatement.setInt(1,id);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call delete_employee(?)");
            callableStatement.setInt(1,id);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call search_customer(?)");
            callableStatement.setString(1,name);

            ResultSet resultSet = callableStatement.executeQuery();

            Customer customer;
            while (resultSet.next()){
                customer = new Customer();
                customer.setCustomer_type(resultSet.getInt("customer_type"));
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                customer.setCustomer_gender(resultSet.getInt("customer_gender"));
                customer.setCustomer_phone(resultSet.getString("customer_phone"));
                customer.setCustomer_email(resultSet.getString("customer_email"));
                customer.setCustomer_address(resultSet.getString("customer_address"));

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_new_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,String.valueOf(customer.getCustomer_id()));
            callableStatement.setString(2,String.valueOf(customer.getCustomer_type()));
            callableStatement.setString(3,customer.getCustomer_name());
            callableStatement.setString(4,customer.getCustomer_birthday());
            callableStatement.setString(5,String.valueOf(customer.getCustomer_gender()));
            callableStatement.setString(6,customer.getCustomer_id_card());
            callableStatement.setString(7,customer.getCustomer_phone());
            callableStatement.setString(8,customer.getCustomer_email());
            callableStatement.setString(9,customer.getCustomer_address());
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Employee> searchEmployee(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call search_employee(?)");
            callableStatement.setString(1,name);

            ResultSet resultSet = callableStatement.executeQuery();

            Employee employee;
            while (resultSet.next()){
                employee = new Employee();
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_gender(resultSet.getInt("employee_gender"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_position(resultSet.getInt("position_id"));
                employee.setEmployee_address(resultSet.getString("employee_address"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  employeeList;
    }

    @Override
    public List<Employee> findAllEmployee() {
            List<Employee> employeeList = new ArrayList<>();
            try {
                CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_all_employee()");

                ResultSet resultSet = callableStatement.executeQuery();

                Employee employee;
                while (resultSet.next()){
                    employee = new Employee();
                    employee.setEmployee_salary(Double.parseDouble(resultSet.getString("employee_salary")));
                    employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
                    employee.setEmployee_name(resultSet.getString("employee_name"));
                    employee.setEmployee_gender(resultSet.getInt("employee_gender"));
                    employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                    employee.setEmployee_email(resultSet.getString("employee_email"));
                    employee.setEmployee_phone(resultSet.getString("employee_phone"));
                    employee.setEmployee_position(resultSet.getInt("position_id"));
                    employee.setEmployee_address(resultSet.getString("employee_address"));

                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return employeeList;
        }

    @Override
    public void addEmployee(Employee employee) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_new_employee(?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1,String.valueOf(employee.getEmployee_id()));
            callableStatement.setString(2,employee.getEmployee_name());
            callableStatement.setString(3,employee.getEmployee_birthday());
            callableStatement.setString(4,String.valueOf(employee.getEmployee_gender()));
            callableStatement.setString(5,employee.getEmployee_id_card());
            callableStatement.setString(6,String.valueOf(employee.getEmployee_salary()));
            callableStatement.setString(7,employee.getEmployee_phone());
            callableStatement.setString(8,employee.getEmployee_email());
            callableStatement.setString(9,employee.getEmployee_address());
            callableStatement.setString(10,String.valueOf(employee.getEmployee_position()));
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
