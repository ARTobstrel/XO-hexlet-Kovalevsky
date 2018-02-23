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

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupaiedException e) {}
    }
}