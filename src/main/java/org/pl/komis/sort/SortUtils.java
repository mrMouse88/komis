package org.pl.komis.sort;

import org.pl.komis.car.Car;
import org.pl.komis.car.CarList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {
    public static List<Car> sortByPriceAsc() {
        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getPrice)).
                collect(Collectors.toList());
    }

    public static List<Car> sortByPriceDesc() {
        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getPrice).reversed()).
                collect(Collectors.toList());
    }

    public static List<Car> sortByBrand() {
        return CarList.carList.stream()
                .sorted(Comparator.comparing(Car::getBrand))
                .collect(Collectors.toList());
    }

    public static List<Car> sortByYearAsc() {
        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getYear)).
                collect(Collectors.toList());
    }

    public static List<Car> sortByYearDesc() {

        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getYear).reversed()).
                collect(Collectors.toList());
    }

    public static List<Car> sortByMileageAsc() {
        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getMileage)).
                collect(Collectors.toList());
    }

    public static List<Car> sortByMileageDesc() {

        return CarList.carList.stream().
                sorted(Comparator.comparing(Car::getMileage).reversed()).
                collect(Collectors.toList());
    }

    public static List<Car> sortByType(){
        return CarList.carList.stream()
                .sorted(Comparator.comparing(Car::getCarType))
                .collect(Collectors.toList());
    }

}
