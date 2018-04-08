package com.jalon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jalon on 08/04/2018.
 */
/**  ����
 * ���Ĳ������ͷ�Ϊ���֣� @ https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 Intermediate��һ�������Ժ������������� intermediate ��������Ŀ����Ҫ�Ǵ���������ĳ�̶ֳȵ�����ӳ��/���ˣ�Ȼ�󷵻�һ���µ�����������һ������ʹ�á�����������Ƕ��Ի��ģ�lazy��������˵���������õ����෽������û��������ʼ���ı�����
 Terminal��һ����ֻ����һ�� terminal ���������������ִ�к����ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ��������Terminal ������ִ�У��Ż�������ʼ���ı��������һ�����һ�����������һ�� side effect��

 ��֮��Stream �����Կ��Թ���Ϊ��
 �������ݽṹ
 ��û���ڲ��洢����ֻ���ò����ܵ��� source�����ݽṹ�����顢generator function��IO channel��ץȡ���ݡ�
 ��Ҳ�����޸��Լ�����װ�ĵײ����ݽṹ�����ݡ����� Stream �� filter ���������һ��������������Ԫ�ص��� Stream�������Ǵ� source ɾ����ЩԪ�ء�
 ���� Stream �Ĳ��������� lambda ���ʽΪ����
 ��֧����������
 ����������һ��Ԫ�أ����޷�����ڶ������������������һ���������������һ�
 ����������������� List
 ���Ի�
 �ܶ� Stream ����������ӳٵģ�һֱ����Ū����������Ҫ�������ݲŻῪʼ��
 Intermediate ������Զ�Ƕ��Ի��ġ�
 ��������
 ��һ�� Stream �ǲ��л��ģ��Ͳ���Ҫ��д���̴߳��룬���ж����Ĳ������Զ����н��еġ�
 ���������޵�
 �����й̶���С��Stream �򲻱ء�limit(n) �� findFirst() ����� short-circuiting �������Զ����޵� Stream �������㲢�ܿ���ɡ�
 */
public class StreamSample {
    public static void main(String[] args) {
        create();
        originStream();
        //toOther();
        joinString();

    }

    /**
     * ���Ĳ���
     ������������һ�����ݽṹ��װ�� Stream �󣬾�Ҫ��ʼ�������Ԫ�ؽ��и�������ˡ������Ĳ������Թ������¡�
     Intermediate��
     map (mapToInt, flatMap ��)�� filter�� distinct�� sorted�� peek�� limit�� skip�� parallel�� sequential�� unordered
     Terminal��
     forEach�� forEachOrdered�� toArray�� reduce�� collect�� min�� max�� count�� anyMatch�� allMatch�� noneMatch�� findFirst�� findAny�� iterator
     Short-circuiting��
     anyMatch�� allMatch�� noneMatch�� findFirst�� findAny�� limit
     */


    //  Stream.collect������  http://www.uucode.net/201406/java8-stream-collect
    public static void joinString() {
        // �ַ���ƴ��
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
        // TODO IntStream��LongStream��DoubleStream
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
