package com.example.atumation.casino.games;

import org.springframework.stereotype.Service;

@Service
public class Blackjack extends CasinoGame {

    private String gameName = "Blackjack";

    public void Shuffle() {
        System.out.println("Shuffling deck");
    }

    public void Draw(int bet, String userName) {
        boolean playResult = playGames(bet, userName, gameName);
        if (playResult) {
            Shuffle();
            System.out.println("Drawing cards");
            gameOver(gameName, userName);
        }
    }

}
