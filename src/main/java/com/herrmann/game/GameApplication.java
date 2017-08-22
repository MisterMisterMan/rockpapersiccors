package com.herrmann.game;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by herrmann on 22/08/17.
 */
public class GameApplication {

    private static final GameLogic GAME_LOGIC = new GameLogic();
    private static final OptionReader OPTION_READER = new OptionReader();

    public static void main(String[] args) {
        System.out.println("Willkommen zum Spiel 'Schere Stein Papier' :-)");
        System.out.println("Ihre Auswahl:");
        for (Option option : Option.values()) {
            System.out.println(option.getId() + " - " + option.name());
        }
        Option userOption = null;
        boolean isInputInvalid = true;
        while (isInputInvalid) {
            System.out.println("Wählen Sie eine Option:");
            Scanner sc = new Scanner(System.in);
            userOption = OPTION_READER.readFromString(sc.next());
            isInputInvalid = userOption == null;
        }
        Option randomOption = Option.getById(createRandomOptionId());
        Result result = GAME_LOGIC.beats(userOption,randomOption);
        System.out.println(userOption.name() + " gegen " + randomOption.name());
        System.out.println(result.getMessage());
    }

    private static int createRandomOptionId() {
        return ThreadLocalRandom.current().nextInt(0, Option.values().length);
    }


}
