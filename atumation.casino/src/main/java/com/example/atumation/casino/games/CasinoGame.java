package com.example.atumation.casino.games;


import com.example.atumation.casino.player.Player;
import com.example.atumation.casino.player.Regestration;
import org.springframework.beans.factory.annotation.Autowired;


abstract class CasinoGame {

    @Autowired
    private Regestration regestration;

    public boolean playGames(int bet, String userName, String gameName) {
        Player player = regestration.findPlayer(userName);
        int balance = player.getBalance();
        if (balance >= bet) {
            playGame(bet, player);
            System.out.println(gameName + " validation passed");
            return true;
        } else {
            System.out.println(gameName + " validation failed");
            return false;
        }
    }

    public void gameOver(String gameName, String userName) {
        Player player = regestration.findPlayer(userName);
        System.out.println("Finished round " + gameName + " for player " + userName + ", current balance: " + player.getBalance());
    }

    public void playGame(int bet, Player player) {
        int balance = player.getBalance();
        if (bet % 2 == 0) {
            balance += bet;
        } else {
            balance -= bet;
        }
        player.setBalance(balance);
    }
}
