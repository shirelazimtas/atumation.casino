package com.example.atumation.casino.player;

public class Player {

    private String userName;
    private int balance;

    public Player(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("withdraw amount cannot be negative");
        }
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

}


