package com.jalon.sample;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jalon on 25/04/2018.
 *
 * Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.
   每个字母从a-z 分别计分 1-26
   You need to return the highest scoring word as a string.
   找出分数最高的单词
 */
public class HighestScoringWord {

	public static String high(String s) {
//		String max = null;
//		int size = 0;
//		for (String x : lx ) {
//			for(byte b : x.getBytes()){
//				size=size+b;
//			}
//		}
//		int iy = Arrays.stream(s.split(" ")).sorted(String::compareTo).mapToInt( x -> {
//																int size = 0;
//																for (byte b : x.getBytes()) size = size + b;
//																return size ;
//															}).max().getAsInt();

//		List<String > ls = Arrays.stream(s.split(" ")).sorted(String::compareTo).map(x ->{
//															int size = 0;
//															for (byte b : x.getBytes()) size = size + b;
//															return x+":"+size ;
//														}).collect(Collectors.toList());


		return Arrays.stream(s.split(" ")).sorted(String::compareTo).max((x,y) ->{
			long xsize = 0;
			long ysize = 0;
			for (byte a : x.getBytes()) xsize = xsize + a - 96;
			for (byte b : y.getBytes()) ysize = ysize + b - 96;
			return  Long.compare(xsize,ysize);
		}).get();
	}

	public static String high2(String s) {
		return Arrays.stream(s.split(" "))
				.max(Comparator.comparingInt(
						a -> a.chars().map(i -> i - 96).sum()
				)).get();
	}

}
