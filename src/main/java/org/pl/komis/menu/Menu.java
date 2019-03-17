package org.pl.komis.menu;

import org.pl.komis.account.Account;
import org.pl.komis.car.CarList;
import org.pl.komis.car.CarType;
import org.pl.komis.filter.Filters;
import org.pl.komis.sort.SortUtils;

import java.math.BigDecimal;
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
        System.out.println("4 - filtruj listę");
        System.out.println("5 - sprzedaj pojazd");
        System.out.println("6 - wyświetl stan konta");
        System.out.println("7 - koniec");
    }

    //wyświetl menu sortowania
    private static void showSortMenu() {
        System.out.println("Sortuj po:");
        System.out.println("1 - cenie rosnąco");
        System.out.println("2 - cenie malejąco");
        System.out.println("3 - marce");
        System.out.println("4 - przebiegu rosnąco");
        System.out.println("5 - przebiegu malejąco");
        System.out.println("6 - roczniku rosnąco");
        System.out.println("7 - roczniku malejąco");
        System.out.println("8 - typie");
    }

    //wyświetl menu filtrowania
    private static void showFilterMenu() {
        System.out.println("Filtruj po:");
        System.out.println("1 - cenie");
        System.out.println("2 - przebiegu");
        System.out.println("3 - roczniku");
        System.out.println("4 - marce");
        System.out.println("5 - filtruj");
    }

    //logika filtrowania
    public static void filterMenu() {
        Scanner input = new Scanner(System.in);
        Filters filters = new Filters(CarList.carList);
        boolean flag = true;

        while (flag) {
            showFilterMenu();
            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("Podaj minimalną cenę");
                        BigDecimal minPrice = MenuUtils.getPriceFromUser();
                        System.out.println("Podaj maksymalną cenę");
                        BigDecimal maxPrice = MenuUtils.getPriceFromUser();
                        filters.filterByPrice(minPrice, maxPrice);
                        break;
                    case 2:
                        System.out.println("Podaj minimalny przebieg");
                        int minMileage = MenuUtils.getIntFromUser();
                        System.out.println("Podaj maksymalny przebieg");
                        int maxMileage = MenuUtils.getIntFromUser();
                        filters.filterByMileage(minMileage, maxMileage);
                        break;
                    case 3:
                        System.out.println("Podaj minimalny rocznik");
                        int minYear = MenuUtils.getIntFromUser();
                        System.out.println("Podaj maksymalny rocznik");
                        int maxYear = MenuUtils.getIntFromUser();
                        filters.filterByYear(minYear, maxYear);
                        break;
                    case 4:
                        System.out.println("Podaj markę");
                        String brand = MenuUtils.getStringFromUser();
                        filters.filterByBrand(brand);
                        break;
                    case 5:
                        MenuUtils.showCarList(filters.returnListOfCars());
                        flag = false;
                        break;
                    default:
                        System.out.println("zły wybór");
                }
            }
        }
    }

    //logika menu sortowania
    public static void sortMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            showSortMenu();
            if (input.hasNextInt()) {
                switch (input.nextInt()) {
                    case 1:
                        CarList.carList = SortUtils.sortByPriceAsc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 2:
                        CarList.carList = SortUtils.sortByPriceDesc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 3:
                        CarList.carList = SortUtils.sortByBrand();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 4:
                        CarList.carList = SortUtils.sortByMileageAsc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 5:
                        CarList.carList = SortUtils.sortByMileageDesc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 6:
                        CarList.carList = SortUtils.sortByYearAsc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 7:
                        CarList.carList = SortUtils.sortByYearDesc();
                        MenuUtils.showCarList(CarList.carList);
                        flag = false;
                        break;
                    case 8:
                        CarList.carList = SortUtils.sortByType();
                        MenuUtils.showCarList(CarList.carList);
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
                        CarList.addCarToList(brand, model, year,mileage, price, color, type);
                        break;
                    //wyświetl listę
                    case 2:
                        System.out.println("Dostępne pojazdy:");
                        MenuUtils.showCarList(CarList.carList);
                        break;
                    //przejdź do menu sortowania
                    case 3:
                        sortMenu();
                        break;
                    case 4:
                        //przejdź do menu filtrowania
                        filterMenu();
                        break;
                    //przedaj pojazd
                    case 5:
                        System.out.println("Podaj id auta");
                        CarList.removeCarFromList(MenuUtils.getIntFromUser());
                        break;
                    //wyświetl stan konta
                    case 6:
                        System.out.println("Stan konta: " + Account.getAccount());
                        break;
                    //zakończ program
                    case 7:
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



