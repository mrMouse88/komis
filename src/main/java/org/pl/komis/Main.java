package org.pl.komis;

import org.pl.komis.car.Car;
import org.pl.komis.car.CarList;
import org.pl.komis.car.CarType;
import org.pl.komis.menu.Menu;
import org.pl.komis.menu.MenuUtils;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        Menu.showInitial();
        Car c1 = new Car("marka", "model", new BigDecimal("10000"), "czarny", 100000, 2015, CarType.SEDAN);
        Car c2 = new Car("marka", "model", new BigDecimal("20000"), "czarny", 100000, 2015, CarType.SEDAN);
        Car c3 = new Car("marka", "model", new BigDecimal("30000"), "czarny", 100000, 2015, CarType.SEDAN);
        CarList.carList.add(c1);
        CarList.carList.add(c2);
        CarList.carList.add(c3);
//        CarList.showCarList();
//        CarList.removeCarFromList(1);
//        CarList.showCarList();

        Menu.mainMenu();

    }

}
