package com.example.atumation.casino.play.game;

import com.example.atumation.casino.games.Blackjack;
import com.example.atumation.casino.games.Roulette;
import com.example.atumation.casino.games.Slots;
import com.example.atumation.casino.player.Player;
import com.example.atumation.casino.player.Regestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheGreatCasino {

    @Autowired
    private Regestration regestration;

    @Autowired
    private Slots slots;

    @Autowired
    private Blackjack blackjack;

    @Autowired
    private Roulette roulette;

    public void runCasino(String[] actions) {
        try {
            for (int i = 0; i < actions.length; i++) {
                String[] commandSplit = actions[i].split(",");
                Action action = new Action(commandSplit[0], commandSplit[1], Integer.valueOf(commandSplit[2]));
                actionPlay(action);
            }
        } catch (Exception exception) {
            System.out.println("The exception was thrown: " + exception);
        }

    }

    public void actionPlay(Action action) throws Exception {
        String command = action.getCommand();
        String userName = action.getUsername();
        int amount = action.getAmount();
        Optional<Player> player = regestration.players.parallelStream().filter(player1 -> player1.getUserName().equals(userName)).findFirst();
        switch (command) {
            case "register":
                regestration.register(userName, amount);
                break;
            case "deposit":
                if (player.isPresent()) {
                    player.get().deposit(amount);
                }
                break;
            case "withdraw":
                if (player.isPresent()) {
                    player.get().withdraw(amount);
                }
                break;
            case "playSlots":
                if (player.isPresent()) {
                    slots.start(amount, userName);
                }
                break;
            case "playBlackjack":
                if (player.isPresent()) {
                    blackjack.Draw(amount, userName);
                }
                break;
            case "playRoulette":
                if (player.isPresent()) {
                    roulette.spin(amount, userName);
                }
                break;
            default:
                System.out.println("Don't have support for this action");
        }
    }
}
