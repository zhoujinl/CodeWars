package com.jalon.sample;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jalon on 02/04/2018.
 * HighAndLow("1 2 3 4 5") // return "5 1"
 * HighAndLow("1 2 -3 4 5") // return "5 -3"
 * HighAndLow("1 9 3 4 -5") // return "9 -5"
 */
public class HighAndLow {

    //1.
    public static String HighAndLow(String numbers) {
        // Code here or
        List<String> ln = Arrays.asList(numbers.split(" "));
        IntSummaryStatistics is  = ln.stream().mapToInt(x -> Integer.parseInt(x)).summaryStatistics();
        return is.getMax()+" " + is.getMin();
    }
    //2
    public static String HighAndLow2(String numbers) {
        // Code here or
        IntSummaryStatistics is  = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        //return is.getMax() + " " + is.getMin();
        return String.format("%d %d",is.getMax(), is.getMin()) ;
    }

    //3 StringArrays to intArrays
    public static void func(){
        String line = "1 2 3 4 5";
        List<Integer> elements = Arrays.stream(line.split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}