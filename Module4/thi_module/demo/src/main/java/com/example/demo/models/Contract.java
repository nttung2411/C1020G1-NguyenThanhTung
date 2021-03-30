package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Contract {
    @Id
    @Pattern(regexp = "^(MGD-)\\d{3}$", message = "Định dạng MGD-XXX")
    private String idContract;
    @Pattern(regexp = "(Nhà Đất)|(Đất Nền)", message = "Nhà đất hoặc đất nền")
    private String typeService;
    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "Đúng định dạng YYYY-MM-DD")
    private String dateTrade;
    @Min(value = 1, message = "Phải là số dương")
    private Double cost;
    @Min(value = 1, message = "Phải là số dương")
    private Double area;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    Customer customer;

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getDateTrade() {
        return dateTrade;
    }

    public void setDateTrade(String dateTrade) {
        this.dateTrade = dateTrade;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
