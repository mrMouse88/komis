package org.pl.komis.menu;

import org.pl.komis.car.CarType;

import java.math.BigDecimal;
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
    public static CarType getCarTypeFromUser() {
        Scanner input = new Scanner(System.in);
        while (true) {
            String type = input.nextLine();
            for (CarType carType : CarType.values()) {
                if (carType.name().equals(type)) {
                    return carType;
                }
            }
            input.next();
        }
    }
}
