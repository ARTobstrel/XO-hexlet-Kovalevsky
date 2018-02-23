package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupaiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();

        assertEquals(3,field.getSize());
    }

    @Test
    public void setFigure() throws InvalidPointException, AlreadyOccupaiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure expectFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectFigure, actualFigure);
    }
}