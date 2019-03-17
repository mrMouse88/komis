package org.pl.komis;

import org.pl.komis.account.Account;
import org.pl.komis.auth.Authorization;
import org.pl.komis.car.Car;
import org.pl.komis.car.CarList;
import org.pl.komis.car.CarType;
import org.pl.komis.menu.Menu;
import org.pl.komis.menu.MenuUtils;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Authorization auth = new Authorization();

        if(auth.checkAuthorization(auth.getPassword())){
            //inicjalizacja
            Menu.initial();
            //uruchom główne menu
            Menu.mainMenu();

        }else{
            System.out.println("Saper myli się tylko raz!");
        }

    }

}