package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    public void show (final Game game) {
        System.out.printf("Game name: %s\n", game.getGameName());
        final Field field = game.getField();
        for (int x=0; x<field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public void move(final Game game) {

    }

    private int askCordinate(final String coordinateName) {
        System.out.printf("Please input %s: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private void printLine(final Field field,
                           final int x) {

        for (int y=0; y<field.getSize(); y++){
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try{
                figure = field.getFigure(new Point(x, y));
            } catch (final InvalidPointException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("-----------");
    }
}
