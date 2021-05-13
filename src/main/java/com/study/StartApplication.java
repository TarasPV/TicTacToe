package com.study;

import com.study.games.logic.IGame;
import com.study.games.logic.TicTacToe;
import com.study.games.settings.TicTacToeSetting;
import com.study.games.users.Player;
import com.study.tools.Utils;

public class StartApplication {

    public static void main(String[] args) {

        Player[] players = initGamePlayers();
        IGame currentlyGame = initTicTacToeGameBoard();

        startGame(currentlyGame, players);
    }

    private static void startGame(IGame game, Player[] players) {
        System.out.println("The game is starting!");
        game.printGameBoard();

        do {
            playerCourse(game, players);
            game.printGameBoard();
        } while (game.isGameStarted());

        game.showWinnerPlayer();
    }

    private static void playerCourse(IGame game, Player[] players) {
        for (Player player : players) {
            if (game.isGameStarted()) {
                System.out.println(player.getName() + " is your turn");
                game.enterUserData(player);
            }
        }
    }

    private static Player[] initGamePlayers() {
        TicTacToeSetting.players = new Player[TicTacToeSetting.getCountPlayers()];

        for (int i = 0; i < TicTacToeSetting.getCountPlayers(); i++) {
            Player player = new Player();
            player.setName(Utils.getEnteredStringData("Please enter name player № " + (i + 1) + ": \n"));
            player.setRandomId(Utils.generateRandomNumber());

            TicTacToeSetting.players[i] = player;
        }

        TicTacToeSetting.sortPlayerArray();
        TicTacToeSetting.setPlayerTicTacToeType();

        return TicTacToeSetting.players;
    }

    private static TicTacToe initTicTacToeGameBoard() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initializeGameBoard();
        return ticTacToe;
    }
}