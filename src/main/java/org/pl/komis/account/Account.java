package org.pl.komis.account;

import java.math.BigDecimal;

public class Account {
    //konto bankowe komisu
    public static BigDecimal account = new BigDecimal(0);

    public static BigDecimal getAccount() {
        return account;
    }

    public static void setAccount(BigDecimal account) {
        Account.account = account;
    }
}
