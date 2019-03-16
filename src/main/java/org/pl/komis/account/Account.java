package org.pl.komis.account;

import java.io.*;
import java.math.BigDecimal;

public class Account {
    //konto bankowe komisu
    private static BigDecimal account = new BigDecimal(0);

    public static BigDecimal getAccount() {
        return account;
    }

    public static void setAccount(BigDecimal account) {
        Account.account = account;
    }


    public static void saveAccount() {
        try {
            //przygotowanie pliku
            PrintWriter writer = new PrintWriter(new FileWriter("account.txt"));

            //zapisz stan konta do pliku
            writer.println(account);

            //zamknięcie pliku
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadAccount() {
        String state = new String();
        try {
            //przygotowanie pliku
            BufferedReader read = new BufferedReader(new FileReader("account.txt"));

            //wczytaj stan konta
            state = read.readLine();

            //zamknięcie pliku
            read.close();

        } catch (FileNotFoundException e) {
            //jeśli brak pliku przypisz 0 do stanu konta
            state = "0";
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!state.equals(null)) {
            account = new BigDecimal(state);
        } else {
            account = new BigDecimal(0);
        }
    }

    public static void main(String[] args) {
        loadAccount();
        System.out.println(account);
        setAccount(getAccount().add(new BigDecimal(123)));
        saveAccount();
    }
}
