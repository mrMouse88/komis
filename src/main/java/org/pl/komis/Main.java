package org.pl.komis;

import org.pl.komis.auth.Authorization;
import org.pl.komis.menu.Menu;


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