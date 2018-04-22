package com.jalon.sample;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by JinQiu on 2018/4/22.
 *
 * Given a number, return a string with dash'-'marks before and after each odd integer, but do not begin or end the string with a dash mark.
     Ex:
     dashatize(274) -> '2-7-4'
     dashatize(6815) -> '68-1-5'
 */
public class DashatizeIt {

    public static String dashatize(int num) {
        String str = Arrays.stream(String.valueOf(Math.abs(Long.valueOf(num))).split("")).
                map(i -> Integer.parseInt(i) % 2 == 1 ? '-' + i + "-" : i).
                collect(Collectors.joining()).
                toString().
                replace("--", "-");
        str = str.startsWith("-") ? str.substring(1) : str;
        str = str.endsWith("-") ? str.substring(0, str.length() - 1) : str;
        return str;
    }

    public static String dashatize1(int num) {
        return Integer.toString(num).replaceAll("([13579])", "-$1-").
                replaceAll("--", "-").
                replaceAll("^-", "").
                replaceAll("-$", "");
    }
    public static String dashatize2(int num) {
        return String.valueOf(num)
                .replaceAll("([13579])", "-$1-")
                .replaceAll("(?<=^)-+|-+(?=-|$)", "");
    }
}
