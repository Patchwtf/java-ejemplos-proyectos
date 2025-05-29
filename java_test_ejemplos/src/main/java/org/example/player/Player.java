package org.example.player;

public class Player {
    private Dice dado;
    private int minNumberToWin;

    public Player(Dice dado, int minNumberToWin) {
        this.dado = dado;
        this.minNumberToWin = minNumberToWin;
    }

    public boolean play(){
        int diceNumber = dado.roll();
        return diceNumber > minNumberToWin;
    }
}
