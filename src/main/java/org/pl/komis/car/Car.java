package org.pl.komis.car;

import java.math.BigDecimal;

public class Car {
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

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                ", carType=" + carType +
                '}';
    }
}
