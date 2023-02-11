package com.example.atumation.casino.games;

import org.springframework.stereotype.Service;

@Service
public class Slots extends CasinoGame {

    private String gameName = "Slots";

    public void start(int bet, String userName) {
        boolean playResult = playGames(bet, userName, gameName);
        if (playResult) {
            System.out.println("Spinning the reels");
            gameOver(gameName, userName);
        }
    }

}
