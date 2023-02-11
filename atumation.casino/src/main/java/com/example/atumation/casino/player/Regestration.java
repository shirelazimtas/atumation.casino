package com.example.atumation.casino.player;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class Regestration {

    public List<Player> players = new ArrayList<>();

    public void register(String userName, int amount) throws Exception {
        if (players != null) {
            Optional<Player> existPlayer = players.parallelStream().filter(player1 -> player1.getUserName().equals(userName)).findFirst();
            if (existPlayer.isPresent()) {
                throw new Exception("The user name is already exist");
            }
        }if (amount < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        Player player = new Player(userName, amount);
        players.add(player);
    }

    public Player findPlayer(String userName) {
        Optional<Player> player = players.parallelStream().filter(player1 -> player1.getUserName().equals(userName)).findFirst();
        return player.get();
    }

}
