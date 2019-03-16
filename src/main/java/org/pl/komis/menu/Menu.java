package org.pl.komis.menu;

import org.pl.komis.car.CarList;

import java.util.Scanner;

public class Menu {
    public static void showInitial() {
        System.out.println("Komis samochodowy 1.0");
    }

    public static void showMainMenu() {
        System.out.println("Wybierz opcję:");
        System.out.println("1 - dodaj pojazd");
        System.out.println("2 - wyświetl listę");
        System.out.println("3 - sortuj listę");
        System.out.println("4 - sprzedaj pojazd");
        System.out.println("5 - wyświetl przychód");
        System.out.println("6 - koniec");
    }


    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showMainMenu();
            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    case 1:
                        CarList.addCarToList();
                        break;
                    case 2:
                        CarList.showCarList();
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Opcja niedostępna lub niepoprawna");
                        break;
                }
            } else {
                input.nextLine();
            }
        }
    }
}



