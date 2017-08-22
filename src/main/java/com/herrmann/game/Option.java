package com.herrmann.game;

/**
 * Created by herrmann on 22/08/17.
 */
public enum Option {
    Schere(0),
    Stein(1),
    Papier(2);

    Option(int id) {
        this.id = id;
    }

    private final int id;

    public int getId() {
        return id;
    }

    public static Option getById(int id) {
        for (Option option : values()) {
            if (option.getId() == id) return option;
        }
        throw new IllegalArgumentException("ID: " + id + " is not defined as an option!");
    }
}
