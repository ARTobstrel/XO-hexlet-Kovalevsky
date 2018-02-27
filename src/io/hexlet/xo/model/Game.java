package io.hexlet.xo.model;

public class Game {

    private final Player[] players;

    private final Field field;

    private final String gameName;

    public Game(final Player[] players, final Field field, final String gameName) {
        this.players = players;
        this.field = field;

        this.gameName = gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getGameName() {
        return gameName;
    }
}
