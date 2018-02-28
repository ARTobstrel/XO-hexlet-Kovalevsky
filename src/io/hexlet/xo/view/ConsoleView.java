package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show (final Game game) {
        System.out.printf("Game name: %s\n", game.getGameName());
        final Field field = game.getField();
        for (int x=0; x<field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null){
            final Figure winner = winnerController.getWinner(field);
            if (winner == null) {
                System.out.println("No winner and no moves left!");
                return false;
            } else {
                System.out.printf("Winner is: %s\n", winner);
                return false;
            }
        }
        System.out.printf("Please, enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCordinate("X")-1, askCordinate("Y")-1);
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
