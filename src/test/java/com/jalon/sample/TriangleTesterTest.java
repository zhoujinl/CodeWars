package com.jalon.sample;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Jalon on 02/04/2018.
 */

public class TriangleTesterTest {
    @Test
    public void publicTests() {
        assertEquals(TriangleTester.isTriangle(1,2,2), true);
        assertEquals(TriangleTester.isTriangle(7,2,2), false);
    }
}