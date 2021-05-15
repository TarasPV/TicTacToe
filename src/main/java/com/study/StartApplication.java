package com.study;

import com.study.games.logic.IGame;
import com.study.games.logic.TicTacToe;
import com.study.games.settings.TicTacToeSetting;
import com.study.games.users.Player;
import com.study.tools.Utils;

public class StartApplication {

    private final static String YES = "y";
    private final static String NO = "n";

    private static IGame currentlyGame;

    public static void main(String[] args) {

        Player[] players = initGamePlayers();
        startGame(players);
    }

    private static void startGame(Player[] players) {
        currentlyGame = initTicTacToeGameBoard();

        System.out.println("The game is starting!");
        currentlyGame.printGameBoard();

        do {
            playerCourse(currentlyGame, players);
            currentlyGame.printGameBoard();
        } while (currentlyGame.isGameStarted());

        endGame(players);
        restartGame(players);
    }

    private static void endGame(Player[] players) {
        System.out.println("The game is end!");

        String winner = currentlyGame.getWinnerPlayer(players);
        if (winner != null) {
            System.out.println("Winner is: " + winner);
        } else {
            System.out.println("The game ended in a draw");
        }
    }

    private static void restartGame(Player[] players) {
        String userChoice = Utils.getEnteredStringData("Do you want to play again?(" + YES + "/" + NO + "): ");
        switch (userChoice) {
            case YES:
                startGame(players);
                break;
            case NO:
                System.out.println("bye-bye!");
                break;
            default:
                System.out.println("Sorry, I don't know about that meaning");
                restartGame(players);

        }
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