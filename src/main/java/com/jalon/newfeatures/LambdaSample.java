package com.jalon.newfeatures;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Jalon on 08/04/2018.
 * Lambda 表达式常用举例  @ http://blog.oneapm.com/apm-tech/226.html
 * Lambda 等价于   (params)  -> {expr; .. }
 * Lambda 实现 FunctionInterface 只有一个抽象方法的接口，该Lambda 实现接口方法
 */
public class LambdaSample {

    public static void main(String[] args) {
        thread();
        foreach();
        map();
        mapreduce();


        Consumer<Integer> c = (Integer x) -> { System.out.println(x); };  //void

        BiConsumer<Integer, String> b = (Integer x, String y) -> System.out.println(x + " : " + y); //void

        Predicate<String> p = (String s) -> { return  s == null; };  // boolean

        //sort1();

        sort2();

    }

    public static void sort2() {
        String[] words = new String[]{"lianggzone", "spring", "summer", "autumn", "winter"};
        Arrays.sort(words, (x, y) -> x.compareToIgnoreCase(y));
        Arrays.asList(words).stream().forEach((x)-> System.out.print(x));
    }

    public static void sort1() {
        List<String> wordList = Arrays.asList("lianggzone", "spr", "summer", "autumn", "winter");
        wordList.sort(( w1, w2) ->  Integer.compare(w1.length(), w2.length()));
        wordList.stream().forEach((x)-> System.out.println(x));
    }

    public static void mapreduce() {
        //Old way:
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 0;
        for(Integer n : list) {
            int x = n * n;
            sum = sum + x;
        }

        //New way:
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7);
        int sum2 = list2.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
    }

    public static void map() {
        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            int x = n * n;
            //System.out.println(x);
        }

        //New way:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list1.stream().map((x) -> x * x).forEach(System.out::println);
    }

    public static void foreach() {
        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
           // System.out.println(n);
        }

        //New way:
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));


        //or we can use :: double colon operator in Java 8
        list.forEach(System.out::println);
    }

    public static void thread() {
        //旧方法:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();

        //新方法:
        new Thread(
                () -> System.out.println("Hello from thread")
        ).start();
    }

}
