package com.study.games.settings;

import com.study.games.users.Player;
import com.study.games.types.TicTacToeType;

public class TicTacToeSetting {

    public static Player[] players;

    public static int getCountPlayers() {
        return TicTacToeType.values().length;
    }

    public static void sortPlayerArray() {
        for (int i = 0; i < TicTacToeSetting.players.length - 1; i++) {
            Player player;
            if (TicTacToeSetting.players[i].getRandomId() > TicTacToeSetting.players[i + 1].getRandomId()) {
                player = TicTacToeSetting.players[i];
                TicTacToeSetting.players[i] = TicTacToeSetting.players[i + 1];
                TicTacToeSetting.players[i + 1] = player;
            }
        }
    }

    public static void setPlayerTicTacToeType() {
        for (int i = 0; i < TicTacToeSetting.players.length; i++) {
            TicTacToeSetting.players[i].setTicTacToeType(TicTacToeType.values()[i]);
        }
    }
}
