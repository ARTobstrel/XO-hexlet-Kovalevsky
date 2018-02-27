package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

import java.util.Scanner;

public class XOCLI {

    public static void main(final String[] args) {

        final String name1;
        final String name2;
        Scanner input = new Scanner(System.in);

        System.out.print("Input first player`s name: ");
        name1 = input.nextLine();
        System.out.print("Input second player`s name: ");
        name2 = input.nextLine();

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
    }
}
