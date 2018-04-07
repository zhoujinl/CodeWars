package com.jalon.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jalon on 30/03/2018.
 */
public class APP {

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","C"};
        List<String> wordList = Arrays.asList("a");
        List<String> output = wordList.stream().
                map(x -> x.toUpperCase()).
                collect(Collectors.toList());
        System.out.println(output.toString());

        boolean flag = true;
        flag ^= true;
        System.out.println(flag);

        flag ^= true;
        System.out.println(flag);
        flag ^= true;
        System.out.println(flag);
        flag ^= true;
        System.out.println(flag);

    }

    public static boolean validate3(String n) {
        final boolean[] flag = {(n.length() & 1) == 1};
        return Arrays.stream(
                n.split(""))
                .map(Integer::parseInt)
                .mapToInt(value -> value)
                .map(integer -> ((flag[0] ^= true) ? (integer * 2 - 1) % 9 + 1 : integer))
                .sum() % 10 == 0;
    }
}
