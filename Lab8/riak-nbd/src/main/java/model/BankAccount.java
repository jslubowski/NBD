package model;

import java.util.UUID;

public class BankAccount {

    private String id;
    private String name;
    private String creditCardNumber;
    private double balance;

    public BankAccount(String id, String name, String creditCardNumber, double balance) {
        this.id = id;
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.balance = balance;
    }

    public BankAccount() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
