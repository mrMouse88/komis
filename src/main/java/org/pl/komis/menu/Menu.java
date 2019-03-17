package org.pl.komis.menu;

import org.pl.komis.account.Account;
import org.pl.komis.car.CarList;

import java.util.Scanner;

public class Menu {
    //wyświetl tekst startowy
    public static void initial() {
        //załaduj stan konta z pliku
        Account.loadAccount();
        //załaduj listę aut z pliku
        CarList.readFromFile();
        System.out.println("Komis samochodowy 1.0");
    }

    //wywietl opcje głównego menu
    private static void showMainMenu() {
        System.out.println("Wybierz opcję:");
        System.out.println("1 - dodaj pojazd");
        System.out.println("2 - wyświetl listę");
        System.out.println("3 - sortuj listę");
        System.out.println("4 - sprzedaj pojazd");
        System.out.println("5 - wyświetl stan konta");
        System.out.println("6 - koniec");
    }

    //wyświetl menu sortowania
    private static void showSortMenu() {
        System.out.println("Sortuj po:");
        System.out.println("1 - cenie");
        System.out.println("2 - roczniku");
        System.out.println("3 - przebiegu");
        System.out.println("4 - nazwie");
        System.out.println("5 - kolorze");
    }

    //logika menu sortowania
    public static void sortMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag == true) {
            showSortMenu();
            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("sortowanie1");
                        flag = false;
                        break;
                    case 2:
                        System.out.println("sortowanie2");
                        flag = false;
                        break;
                    default:
                        System.out.println("zły wybór");
                }
            } else {
                //czyszczenie scannera
                input.nextLine();
            }
        }
    }

    //logika głównego menu
    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showMainMenu();
            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    //dodaj pojazd
                    case 1:
                        CarList.addCarToList();
                        break;
                    //wyświetl listę
                    case 2:
                        System.out.println("Dostępne pojazdy:");
                        CarList.showCarList(CarList.carList);
                        break;
                    //przejdź do menu sortowania
                    case 3:
                        sortMenu();
                        break;
                    //przedaj pojazd
                    case 4:
                        System.out.println("Podaj id auta");
                        CarList.removeCarFromList(MenuUtils.getIntFromUser());
                        break;
                    //wyświetl stan konta
                    case 5:
                        System.out.println("Stan konta: " + Account.getAccount());
                        break;
                    //zakończ program
                    case 6:
                        flag = false;
                        Account.saveAccount();
                        CarList.saveCarListToFile();
                        CarList.saveToFile();
                        break;
                    //źle wybrana opcja menu
                    default:
                        System.out.println("Opcja niedostępna lub niepoprawna");
                        break;
                }
            } else {
                //czyszczenie scannera
                input.nextLine();
            }
        }
    }
}



