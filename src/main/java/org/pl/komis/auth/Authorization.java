package org.pl.komis.auth;

import java.util.Base64;
import java.util.Scanner;

public class Authorization {
    private String password = "cGFzczEyMzQ=";

    //sprawdź poprawność hasła
    public boolean checkAuthorization(String password){
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.password.equals(encodedPassword);
    }

    //pobierz hasło od usera
    public String getPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj hasło:");
        return input.nextLine();
    }

}

