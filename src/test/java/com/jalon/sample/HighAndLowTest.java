package com.jalon.sample;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Jalon on 02/04/2018.
 */


public class HighAndLowTest {
    @Test
    public void publicTests() {
        assertEquals("42 -9", HighAndLow.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        assertEquals("42 -11", HighAndLow.HighAndLow2("8 3 -5 42 -1 0 0 -11 4 7 4 -4"));
    }
}