package com.study.games.users;

import com.study.games.types.TicTacToeType;

public class Player {
    private String name;
    private int randomId;
    private TicTacToeType ticTacToeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }

    public TicTacToeType getTicTacToeType() {
        return ticTacToeType;
    }

    public void setTicTacToeType(TicTacToeType ticTacToeType) {
        this.ticTacToeType = ticTacToeType;
    }
}
