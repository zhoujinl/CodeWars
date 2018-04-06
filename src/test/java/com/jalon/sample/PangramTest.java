package com.jalon.sample;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Pangram Tester.
 *
 * @author <Authors name>
 *         判断一句话里面是不是包含了26个字母
 * @version 1.0
 */
public class PangramTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: check(String sentence)
     */
    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        Pangram pc = new Pangram();
        assertEquals(true, pc.check(pangram1));
    }

    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        Pangram pc = new Pangram();
        assertEquals(false, pc.check(pangram2));
    }

}
