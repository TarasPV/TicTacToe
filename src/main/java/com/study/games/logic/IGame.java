package com.study.games.logic;

import com.study.games.users.Player;

public interface IGame {

    boolean isGameStarted();

    void printGameBoard();

    void showWinnerPlayer();

    void enterUserData(Player player);
}
