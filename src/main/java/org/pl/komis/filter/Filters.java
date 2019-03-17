package org.pl.komis.filter;

import org.pl.komis.car.Car;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filters {
    Stream cars;


    public Filters(List<Car> cars) {
        this.cars = cars.stream();
    }

    public void filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        cars = FilterUtils.filterByPrice(cars, minPrice, maxPrice);
    }

    public void filterByMileage(int min, int max) {
        cars = FilterUtils.filterByMileage(cars, min, max);
    }

    public void filterByYear(int min, int max) {
        cars = FilterUtils.filterByYear(cars, min, max);
    }

    public void filterByBrand(String brand){
        cars = FilterUtils.filterByBrand(cars, brand);
    }

    public List<Car> returnListOfCars() {
        return (List<Car>) cars.collect(Collectors.toList());
    }

}
