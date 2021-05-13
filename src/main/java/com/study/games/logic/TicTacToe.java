package com.study.games.logic;

import com.study.games.users.Player;
import com.study.tools.Constants;
import com.study.tools.Utils;

import java.util.Arrays;

public class TicTacToe implements IGame {
    String[][] gameBoard = new String[Constants.COUNT_BOARD_FIELDS][Constants.COUNT_BOARD_FIELDS];

    public void initializeGameBoard() {
        for (String[] strings : gameBoard) {
            Arrays.fill(strings, Constants.EMPTY_BOARD_SYMBOL);
        }
    }

    @Override
    public boolean isGameStarted() {
        return !isBoardFilled();
    }

    @Override
    public void printGameBoard() {
        System.out.println("-------");
        for (String[] strings : gameBoard) {
            System.out.print("|");
            for (String string : strings) {
                System.out.print(string + "|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }

    @Override
    public void enterUserData(Player player) {
        int x = enterDataCoordinate("x");
        int y = enterDataCoordinate("y");
        if (isGameStarted()) {
            if (!isBoardCellEmpty(x, y)) {
                System.out.println("This coordinate already has something");
                enterUserData(player);
                return;
            }
            gameBoard[x][y] = String.valueOf(player.getTicTacToeType());
        }
    }

    @Override
    public void showWinnerPlayer() {
        System.out.println("The game is end!");
        detectWinner();
    }

    private void detectWinner() {
//      TODO:: detect
        printGameBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println("[" + i + "]: " + Arrays.toString(gameBoard[i]));
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[0][j].equals(gameBoard[i][j])) {
                    System.out.println("Its true [" + i + "]: " + Arrays.toString(gameBoard[i]));
                }
            }
        }
    }

    private boolean isEqualsValue(String[] array) {
        for (String s : array) {
            if (!s.equals(array[0])) {
                return false;
            }
        }
        return true;
    }

    private boolean isBoardCellEmpty(int x, int y) {
        return Constants.EMPTY_BOARD_SYMBOL.equals(gameBoard[x][y]);
    }

    private boolean isBoardFilled() {
        for (String[] strings : gameBoard) {
            for (String string : strings) {
                if (Constants.EMPTY_BOARD_SYMBOL.equals(string)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int enterDataCoordinate(String text) {
        int value = Utils.getEnteredIntData(text + ": ");
        if (!Utils.isCorrectValue(value))
            return enterDataCoordinate(text);
        return value - 1;
    }
}
