package com.example.demo.models.contract;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.services.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContract;
    @Column(nullable = false)
    private String startDateContract;
    @Column(nullable = false)
    private String endDateContract;
    @Column(nullable = false)
    private Double deposit;
    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Contract() {

    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public String getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(String startDateContract) {
        this.startDateContract = startDateContract;
    }

    public String getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(String endDateContract) {
        this.endDateContract = endDateContract;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
