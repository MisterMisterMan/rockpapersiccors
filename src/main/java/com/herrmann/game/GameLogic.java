package com.herrmann.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by herrmann on 22/08/17.
 */
public class GameLogic {

    private Map<Option, Option> beatingOptions;

    public Result beats(Option firstOption, Option secondOption) {
        if (firstOption == secondOption) return Result.Draw;
        if (getBeatingOptions().get(firstOption) == secondOption) return  Result.Win;
        return Result.Loose;
    }

    public Map<Option, Option> getBeatingOptions() {
        if (beatingOptions == null) {
            beatingOptions = initBeatingOptions();
        }
        return beatingOptions;
    }

    private Map<Option, Option> initBeatingOptions() {
        Map<Option, Option> beatingOptions = new HashMap<>();
        beatingOptions.put(Option.Papier, Option.Stein);
        beatingOptions.put(Option.Stein, Option.Schere);
        beatingOptions.put(Option.Schere, Option.Papier);
        return beatingOptions;
    }

}
