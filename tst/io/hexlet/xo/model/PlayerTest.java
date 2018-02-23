package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputValue = "Slava";
        final String expectValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectValue, actualValue);
    }

    @Test
    public void getFigure() {
        final Figure inputValue = Figure.X;
        final Figure expectValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectValue, actualValue);
    }
}