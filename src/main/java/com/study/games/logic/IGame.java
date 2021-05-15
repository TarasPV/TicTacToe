package com.study.games.logic;

import com.study.games.users.Player;

public interface IGame {

    boolean isGameStarted();

    void printGameBoard();

    String getWinnerPlayer(Player[] players);

    void enterUserData(Player player);
}
