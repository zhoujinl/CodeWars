package com.jalon.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by JinQiu on 2018/4/22.
 */
public class DashatizeItTest {

    @Test
    public void testBasic() {
        assertEquals("2-7-4", DashatizeIt.dashatize(274));
        assertEquals("5-3-1-1", DashatizeIt.dashatize(5311));
        assertEquals("86-3-20", DashatizeIt.dashatize(86320));
        assertEquals("9-7-4-3-02", DashatizeIt.dashatize(974302));
    }

    @Test
    public void testWeird() {
        assertEquals("0", DashatizeIt.dashatize(0));
        assertEquals("1", DashatizeIt.dashatize(-1));
        assertEquals("28-3-6-9", DashatizeIt.dashatize(-28369));
    }

    @Test
    public void testEdgeCases() {
        System.out.println(Integer.MIN_VALUE);
        assertEquals("2-1-4-7-48-3-64-7", DashatizeIt.dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", DashatizeIt.dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", DashatizeIt.dashatize(-1111111111));
    }

}