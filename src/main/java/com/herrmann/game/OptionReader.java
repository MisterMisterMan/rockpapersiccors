package com.herrmann.game;

/**
 * Created by herrmann on 23/08/17.
 */
public class OptionReader {

    public Option readFromString(String input) {
        input = input.trim();
        for (Option option : Option.values()) {
            if (option.name().toLowerCase().equals(input) ||
                    String.valueOf(option.getId()).equals(input))
                return option;
        }
        return null;
    }

}
