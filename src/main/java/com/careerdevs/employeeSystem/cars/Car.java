package com.careerdevs.employeeSystem.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    private @Id @GeneratedValue Long id;
    private String make;
    private String model;
    private Integer price;

    public Car(){

    }

    public Car(String make, String model, Integer price){
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Car(Long id, String make, String model, Integer price){
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
