package org.example.player;

import java.util.Random;

public class Dice {
    private int caras;

    public int roll(){
        return new Random().nextInt(caras) + 1;
    }

    public Dice(int caras) {
        this.caras = caras;
    }
}
