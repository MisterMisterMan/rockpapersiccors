package com.herrmann.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by herrmann on 23/08/17.
 */
public class GameLogicTest {

    private GameLogic gameLogic = new GameLogic();

    @Test
    public void testSchere() {
        assertEquals(Result.Win, gameLogic.beats(Option.Schere,Option.Papier));
        assertEquals(Result.Draw, gameLogic.beats(Option.Schere,Option.Schere));
        assertEquals(Result.Loose, gameLogic.beats(Option.Schere,Option.Stein));
    }

    @Test
    public void testStein() {
        assertEquals(Result.Win, gameLogic.beats(Option.Stein,Option.Schere));
        assertEquals(Result.Draw, gameLogic.beats(Option.Stein,Option.Stein));
        assertEquals(Result.Loose, gameLogic.beats(Option.Stein,Option.Papier));
    }

    @Test
    public void testPapier() {
        assertEquals(Result.Win, gameLogic.beats(Option.Papier,Option.Stein));
        assertEquals(Result.Draw, gameLogic.beats(Option.Papier,Option.Papier));
        assertEquals(Result.Loose, gameLogic.beats(Option.Papier,Option.Schere));
    }

    @Test
    public void testGameLogicCompleteness() {
        for (Option optionFirst : Option.values()) {
            for (Option optionSecond : Option.values()) {
                Result result = gameLogic.beats(optionFirst,optionSecond);
                Result oppositeResult = gameLogic.beats(optionSecond,optionFirst);
                switch (result) {
                    case Win:
                        assertEquals(Result.Loose, oppositeResult);
                        break;
                    case Loose:
                        assertEquals(Result.Win, oppositeResult);
                        break;
                    case Draw:
                        assertEquals(Result.Draw, oppositeResult);
                        break;
                }
            }
        }
    }
}
