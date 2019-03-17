package org.pl.komis.filter;


import org.pl.komis.car.Car;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class FilterUtils {
    public static Stream filterByPrice(Stream<Car> carsStream, BigDecimal min, BigDecimal max) {
        return carsStream.filter(car -> car.getPrice().compareTo(min) >= 0)
                .filter(car -> car.getPrice().compareTo(max) <= 0);
    }

    public static Stream filterByMileage(Stream<Car> carsStream, int min, int max) {
        return carsStream.filter(car -> car.getMileage() >= min)
                .filter(car -> car.getMileage() <= max);
    }

    public static Stream filterByYear(Stream<Car> carsStream, int min, int max) {
        return carsStream.filter(car -> car.getYear() >= min)
                .filter(car -> car.getYear() <= max);
    }

    public static Stream filterByBrand(Stream<Car> carStream, String brand){
        return carStream.filter(car-> car.getBrand().equals(brand));
    }
}
