package org.pl.komis.auth;

import java.util.Scanner;

public class Authorization {
    private String password = "pass1234";

    //sprawdź poprawność hasła
    public boolean checkAuthorization(String password){
        return this.password.equals(password);
    }

    //pobierz hasło od usera
    public String getPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj hasło:");
        return input.nextLine();
    }
}

