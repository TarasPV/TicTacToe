package com.study.games.logic;

import com.study.games.users.Player;
import com.study.tools.Constants;
import com.study.tools.Utils;

import java.util.ArrayList;
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
        if (detectWinnerType() != null)
            return false;

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
    public String getWinnerPlayer(Player[] players) {
        return getWinnerNameFromType(detectWinnerType(), players);
    }

    private String getWinnerNameFromType(String winnerType, Player[] players) {
        if (winnerType != null) {
            for (Player player : players) {
                if (winnerType.equals(String.valueOf(player.getTicTacToeType()))) {
                    return player.getName();
                }
            }
        }
        return null;
    }

    private String detectWinnerType() {
        ArrayList<String> horizontalArr;
        ArrayList<String> verticalArr;
        ArrayList<String> leftTopToRightBottomArr = new ArrayList<>();
        ArrayList<String> rightTopToLeftBottomArr = new ArrayList<>();

        String winnerType = null;

        for (int i = 0; i < gameBoard.length; i++) {
            horizontalArr = new ArrayList<>();
            verticalArr = new ArrayList<>();
            leftTopToRightBottomArr.add(gameBoard[i][i]);
            rightTopToLeftBottomArr.add(gameBoard[i][gameBoard.length - 1 - i]);

            for (int j = 0; j < gameBoard[i].length; j++) {
                horizontalArr.add(gameBoard[i][j]);
                verticalArr.add(gameBoard[j][i]);
            }

            winnerType = isEqualsValueType(gameBoard.length, horizontalArr);
            if (winnerType != null)
                break;
            winnerType = isEqualsValueType(gameBoard.length, verticalArr);
            if (winnerType != null)
                break;
            winnerType = isEqualsValueType(gameBoard.length, leftTopToRightBottomArr);
            if (winnerType != null)
                break;
            winnerType = isEqualsValueType(gameBoard.length, rightTopToLeftBottomArr);
            if (winnerType != null)
                break;
        }

        return winnerType;
    }

    private String isEqualsValueType(int mainArrayLength, ArrayList<String> arrayList) {
        if (arrayList.size() < mainArrayLength)
            return null;

        for (String value : arrayList) {
            if (value.equals(Constants.EMPTY_BOARD_SYMBOL) || !arrayList.get(0).equals(value)) {
                return null;
            }
        }
        return arrayList.get(0);
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
