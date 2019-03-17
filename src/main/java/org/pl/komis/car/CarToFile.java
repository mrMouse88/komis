package org.pl.komis.car;

import java.io.*;
import java.util.List;

public class CarToFile {

    public static void saveToFile(List<Car> list){
        File file = new File("bazaS.txt");
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            for (Car car : list){
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
}
