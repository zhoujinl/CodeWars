package com.jalon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jalon on 08/04/2018.
 */
/**  特性
 * 流的操作类型分为两种： @ https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。

 总之，Stream 的特性可以归纳为：
 不是数据结构
 它没有内部存储，它只是用操作管道从 source（数据结构、数组、generator function、IO channel）抓取数据。
 它也绝不修改自己所封装的底层数据结构的数据。例如 Stream 的 filter 操作会产生一个不包含被过滤元素的新 Stream，而不是从 source 删除那些元素。
 所有 Stream 的操作必须以 lambda 表达式为参数
 不支持索引访问
 你可以请求第一个元素，但无法请求第二个，第三个，或最后一个。不过请参阅下一项。
 很容易生成数组或者 List
 惰性化
 很多 Stream 操作是向后延迟的，一直到它弄清楚了最后需要多少数据才会开始。
 Intermediate 操作永远是惰性化的。
 并行能力
 当一个 Stream 是并行化的，就不需要再写多线程代码，所有对它的操作会自动并行进行的。
 可以是无限的
 集合有固定大小，Stream 则不必。limit(n) 和 findFirst() 这类的 short-circuiting 操作可以对无限的 Stream 进行运算并很快完成。
 */
public class StreamSample {
    public static void main(String[] args) {
        create();
        originStream();
        //toOther();
        joinString();

    }

    /**
     * 流的操作
     接下来，当把一个数据结构包装成 Stream 后，就要开始对里面的元素进行各类操作了。常见的操作可以归类如下。
     Intermediate：
     map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
     Terminal：
     forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
     Short-circuiting：
     anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
     */


    //  Stream.collect方法详  http://www.uucode.net/201406/java8-stream-collect
    public static void joinString() {
        // 字符串拼接
        System.out.println(Stream.of("a", "b", "c", "d").collect(Collectors.toList()));
    }

    public static void toOther() {
        List<String> list = Arrays.asList("a","b");
        Stream<String>  stream = list.stream();
        // 1. Array
        String[] strArray1 = stream.toArray(String[]::new);
        // 2. Collection
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = stream.collect(Collectors.joining()).toString();
    }

    public static void originStream() {
        // TODO IntStream、LongStream、DoubleStream
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    public static void create() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }
}
