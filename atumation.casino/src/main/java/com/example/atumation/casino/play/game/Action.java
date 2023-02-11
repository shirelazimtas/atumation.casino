package com.example.atumation.casino.play.game;

public class Action {

    private String command;

    private String username;

    private int amount;

    public Action() {
    }

    public Action(String command, String username, int amount) {
        this.command = command;
        this.username = username;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
