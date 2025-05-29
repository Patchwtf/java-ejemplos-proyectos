package org.example.player;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void looseWhenDiceNumberIsTooLow() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertFalse(player.play());
    }

    @Test
    public void winsWhenDiceNumberIsBig() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(3);

        Player player = new Player(dice, 2);
        assertTrue(player.play());
    }
}