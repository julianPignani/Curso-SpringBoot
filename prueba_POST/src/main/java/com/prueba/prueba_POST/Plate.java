package com.prueba.prueba_POST;

import lombok.Getter;
import lombok.Setter;
//Nuestra clase platos
@Getter @Setter
public class Plate {
    private int plateNumber;
    private String name;

    private double price;
    private String description;

    public Plate() {

    }

    public Plate(int plateNumber, String name, double price, String description) {
        this.plateNumber = plateNumber;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
