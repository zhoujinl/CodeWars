package com.jalon.sample;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LuhnAlgorithmTest{
    @Test
    public void test891(){
        assertEquals(false, LuhnAlgorithm.validate("891"));
    }
    @Test
    public void test123(){
        assertEquals(false, LuhnAlgorithm.validate("123"));
    }
    @Test
    public void test1(){
        assertEquals(false, LuhnAlgorithm.validate("1"));
    }
    @Test
    public void test2121(){
        assertEquals(true, LuhnAlgorithm.validate("2121"));
    }
    @Test
    public void test1230(){
        assertEquals(true, LuhnAlgorithm.validate("1230"));
    }
    @Test
    public void test8675309(){
        assertEquals(false, LuhnAlgorithm.validate("8675309"));
    }
    @Test
    public void test4111111111111111(){
        assertEquals(true, LuhnAlgorithm.validate("4111111111111111"));
    }
    @Test
    public void test26(){
        assertEquals(true, LuhnAlgorithm.validate("26"));
    }
    @Test
    public void test2626262626262626(){
        assertEquals(true, LuhnAlgorithm.validate("2626262626262626"));
    }
    @Test
    public void test91(){
        assertEquals(true, LuhnAlgorithm.validate("91"));
    }
    @Test
    public void test92(){
        assertEquals(false, LuhnAlgorithm.validate("92"));
    }
    @Test
    public void test912030(){
        assertEquals(true, LuhnAlgorithm.validate("912030"));
    }
    @Test
    public void test922030(){
        assertEquals(false, LuhnAlgorithm.validate("922030"));
    }
}