package com.jalon.sample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jalon on 25/04/2018.
 */
public class HighestScoringWordTest {

	@Test
	public void sampleTests() {
		assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
		assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
		assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
	}

}