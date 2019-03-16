package org.pl.komis.car;

import org.pl.komis.car.Car;
import org.pl.komis.car.CarType;
import org.pl.komis.menu.MenuUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static List<Car> carList = new ArrayList<Car>();
    public static BigDecimal account = new BigDecimal(0);

    public static void addCarToList() {

        System.out.println("Podaj markę");
        String brand = MenuUtils.getStringFromUser();

        System.out.println("Podaj model");
        String model = MenuUtils.getStringFromUser();

        System.out.println("Podaj rocznik");
        int year = MenuUtils.getIntFromUser();

        System.out.println("Podaj przebieg");
        int mileage = MenuUtils.getIntFromUser();

        System.out.println("Podaj cenę");
        BigDecimal price = MenuUtils.getPriceFromUser();

        System.out.println("Podaj typ nadwozia (SEDAN, LIMOUSINE, WAGON, " +
                "SUV, HATCHBACK, PICKUP, FASTBACK, CONVERTIBLE)");
        CarType type = MenuUtils.getCarTypeFromUser();

        System.out.println("Podaj kolor");
        String color = MenuUtils.getStringFromUser();

        Car car = new Car(brand, model, price, color, mileage, year, type);
    }

    public static void removeCarFromList(int index) {
        carList.remove(index);
    }

    public static void showCarList() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print("Index: " + i + " ");
            System.out.println(carList.get(i).toString());
        }
    }
}
