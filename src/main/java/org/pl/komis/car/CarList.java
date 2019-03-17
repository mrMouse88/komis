package org.pl.komis.car;

import org.pl.komis.account.Account;
import org.pl.komis.menu.MenuUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarList {
    public static List<Car> carList = new ArrayList<Car>();

    public static void addCarToList(String brand, String model, int year, int mileage, BigDecimal price, String color
            , CarType type) {

        Car car = new Car(brand, model, price, color, mileage, year, type);
        carList.add(car);
    }

    public static void removeCarFromList(int index) {
        if (index <= carList.size() - 1 && index >= 0) {
            Account.setAccount(Account.getAccount().add(carList.get(index).getPrice()));
            carList.remove(index);
        } else {
            System.out.println("złe id");
        }
    }



    //zapis do pliku tokeny
    public static void saveCarListToFile() {
        try {
            //przygotowanie pliku
            PrintWriter writer = new PrintWriter(new FileWriter("baza.txt"));

            //dla kazdej pozycji z listy odczytaj do stringa z tokenem | i dodaj do pliku
            for (Car car : carList) {
                StringBuilder row = new StringBuilder();
                row.append(car.getBrand());
                row.append("|");
                row.append(car.getModel());
                row.append("|");
                row.append(car.getPrice());
                row.append("|");
                row.append(car.getColor());
                row.append("|");
                row.append(car.getMileage());
                row.append("|");
                row.append(car.getYear());
                row.append("|");
                row.append(car.getCarType());
                writer.println(row);
            }

            //zamknięcie plik
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //odczyt z pliku tokeny
    public static void loadCarListFromFile() {
        String row = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("baza.txt"));
            while ((row = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(row, "|");
                Car car = new Car(tokenizer.nextToken(),tokenizer.nextToken(),new BigDecimal(tokenizer.nextToken()), tokenizer.nextToken(),
                        Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), CarType.valueOf(tokenizer.nextToken()));
                carList.add(car);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku bazy danych");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //zapis do pliku serializacja
    public static void saveToFile(){
        File file = new File("bazaS.txt");
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            for (Car car : CarList.carList){
                o.writeObject(car);
            }
            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //odczyt z pliku serializacja
    public static void readFromFile(){
        File file = new File("bazaS.txt");
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream o = new ObjectInputStream(f);
            try {
                while (true) {
                    carList.add((Car) o.readObject());
                }
            } catch (EOFException e) {
                o.close();
                f.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku bazy");
        }catch (IOException e) {
            e.printStackTrace();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
