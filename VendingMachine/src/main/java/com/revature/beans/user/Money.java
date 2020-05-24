package com.revature.beans.user;

import com.revature.utils.StringUtil;

public class Money implements Comparable<Money> {
    private int dollars, cents;

    public Money() {
        this(0);
    }

    public Money(int dollars, int cents) {
        this.setDollars(dollars);
        this.setCents(cents);
    }

    public Money(int dollars) {
        this(dollars, 0);
    }

    public Money(Money money) {
        this(money.getDollars(), money.getCents());
    }

    public static Money parseString(String amount) {
        Money money = new Money();

        if (!StringUtil.isStringNullOrEmpty(amount)) {
            if (amount.contains("$"))
                amount = amount.replaceAll("[$]", "");
            if (amount.contains(","))
                amount = amount.replaceAll("[,]", "");
            amount = amount.trim();
            float parsedAmount = Float.parseFloat(amount);
            int dollars = (int) parsedAmount;
            int cents = (int) ((parsedAmount * 100) - (dollars * 100));
            money.setDollars(dollars);
            money.setCents(cents);
        }

        return money;
    }

    public void sub(Money money) {
        this.dollars -= money.getDollars();
        this.dollars -= money.getCents() / 100;
        this.cents -= money.getCents() % 100;
        if (cents < 0) {
            this.dollars--;
            this.cents = 100 - money.getCents();
        }
    }

    public void add(Money money) {
        this.setDollars(this.dollars + money.getDollars());
        this.setCents(this.cents + money.getCents());
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        if (dollars < 0)
            dollars = 0;
        this.dollars = dollars;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        if (cents < 0)
            cents = 0;
        if (cents > 0) {
            dollars += cents / 100;
            cents = cents % 100;
        }
        this.cents = cents;
    }

    @Override
    public String toString() {
        return "$" + getDollars() + "." + getCents();
    }

    @Override
    public int compareTo(Money o) {
        int dollarCompare = Integer.compare(this.dollars, o.dollars);
        int centsCompare = Integer.compare(this.cents, o.cents);
        return dollarCompare == 0 ? centsCompare : dollarCompare;
    }
}