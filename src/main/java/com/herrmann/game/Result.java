package com.herrmann.game;

/**
 * Created by herrmann on 22/08/17.
 */
public enum Result {
    Win("Sie haben gewonnen!"),
    Loose("Sie haben verloren!"),
    Draw("Das Spiel ist unentschieden ausgegangen!");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
