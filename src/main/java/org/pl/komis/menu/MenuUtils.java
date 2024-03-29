package org.pl.komis.menu;

import org.pl.komis.car.Car;
import org.pl.komis.car.CarType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    //pobierz inta od usera
    public static int getIntFromUser() {
        Scanner input = new Scanner(System.in);

        while (true) {
            if (input.hasNextInt()) {
                int output = input.nextInt();
                return output;
            }
            input.next();
        }
    }

    //pobierz stringa od usera
    public static String getStringFromUser() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    //pobierz cenę
    public static BigDecimal getPriceFromUser() {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (input.hasNextBigDecimal()) {
                return input.nextBigDecimal();
            }
            input.next();
        }
    }

    //pobierz typ auta od usera
    //TODO poprawić pobieranie typu, po błędnym podaniu typu nie przyjmuje poprawnego
    public static CarType getCarTypeFromUser() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String type = input.nextLine();
            for (CarType carType : CarType.values()) {
                if (carType.name().equals(type)) {
                    return carType;
                } else {
                    input.nextLine();
                }
            }
            input.nextLine();
        }
    }

    //wyświetlanie listy na konsoli
    public static void showCarList(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print("Id: " + i + " ");
            System.out.println(carList.get(i).toString());
        }
        System.out.println();
    }
}
