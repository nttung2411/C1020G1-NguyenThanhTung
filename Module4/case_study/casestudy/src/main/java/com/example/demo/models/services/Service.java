package com.example.demo.models.services;

import com.example.demo.models.contract.Contract;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Service{
    @Id
    @Pattern(regexp = "^(DV-)\\d{4}$",message = "Định dạng DV-XXXX")
    private String serviceId;
    @Column(nullable = false)
    @NotEmpty(message = "Không được để trống")
    private String serviceName;
    private String standardRoom;
    @Min(value = 50,message = "Phải lớn hơn 50")
    @Max(value = 2000,message = "2000 mét vuông là được rồi")
    private Double area;
    @Min(value = 20,message = "Phải lớn hơn 20")
    @Max(value = 200,message = "200 mét vuông là được rồi")
    private Double poolArea;
    @Min(value = 1,message = "Phải lớn hơn 1")
    @Max(value = 20,message = "20 tầng là được rồi")
    private Integer floor;
    @Min(value = 1,message = "Phải lớn hơn 1")
    @Max(value = 100,message = "100 thằng là được rồi")
    private Integer maxPeople;
    private String descriptionOther;
    @Column(nullable = false)
    @Min(value = 1,message = "Phải lớn hơn 1")
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private TypeService typeService;
    @ManyToOne
    @JoinColumn(name = "service_rent_type_id", referencedColumnName = "rentTypeId")
    private RentTypeService rentTypeService;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    List<Contract> contracts;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public RentTypeService getRentTypeService() {
        return rentTypeService;
    }

    public void setRentTypeService(RentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }
}
