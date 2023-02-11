package com.example.atumation.casino.games;

import org.springframework.stereotype.Service;

@Service
public class Roulette extends CasinoGame {

    private String gameName = "Roulette";

    public void spin(int bet, String userName) {
        boolean playResult = playGames(bet, userName, gameName);
        if (playResult) {
            System.out.println("Spinning wheel");
            gameOver(gameName, userName);
        }
    }
}
