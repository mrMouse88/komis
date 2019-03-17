package org.pl.komis.car;

import java.io.Serializable;
import java.math.BigDecimal;

public class Car implements Serializable {
    private String brand;
    private String model;
    private BigDecimal price;
    private String color;
    private int mileage;
    private int year;
    private CarType carType;

    public Car(String brand, String model, BigDecimal price, String color, int mileage, int year, CarType carType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.mileage = mileage;
        this.year = year;
        this.carType = carType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public CarType getCarType() {
        return carType;
    }

    @Override
    public String toString() {
        return "Marka: " + brand + ", Model: " + model + ", Cena: " + price
                + ", Przebieg: " + mileage + ", Rok produkcji: " + year
                + ", Typ nadwozia: " + carType+", Kolor: "+color;
    }
}
