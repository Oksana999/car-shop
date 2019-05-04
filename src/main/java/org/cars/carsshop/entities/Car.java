package org.cars.carsshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int carId;
    @Column
    private String model;
    @Column
    private String yearBuild;
    @Column
    private double price;
    @Column
    private String type;
    @Column
    private String imageName;

    public Car() {
    }

    public Car(String model, String yearBuild, double price, String type, String imageName) {
        this.model = model;
        this.yearBuild = yearBuild;
        this.price = price;
        this.type = type;
        this.imageName = imageName;
    }
}
