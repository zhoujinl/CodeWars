package com.jalon.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jalon on 10/04/2018.
 */
public class SortSample {

    public static void main(String[] args) {
        int[] it = {355,34,288,56,7,45,723,44,2};
        //bubbleSort(it);
        simpleInsertSort(it);
        //shellSort(it);
        //selectSort(it);
        IntStream.of(it).forEach(i -> System.out.printf("%d ",i));


    }

    /*
 * 冒泡排序  逐个逐个冒泡上去
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @param numbers 需要排序的整型数组
 */
    public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
            //IntStream.of(numbers).forEach(va -> System.out.printf("%d ",va));
            //System.out.println();
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
    /**
     * 插入排序
     *
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     * @param numbers  待排序数组
     */
    public static void simpleInsertSort(int[] numbers)
    {
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < numbers.length ; i++)
        {
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 &&  numbers[j-1] > temp ; j --)
            {
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
            IntStream.of(numbers).forEach(va -> System.out.printf("%d ",va));
            System.out.println();
        }
    }

    /*
    1、基本思想：
    先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
    2、操作方法：

    <code>
    1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
    2、按增量序列个数k，对序列进行k 趟排序；
    3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
    </code>
     */
    public static void shellSort(int[] data)
    {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.length; i++)
            {
                temp = data[i];
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp < data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                    }
                    else
                    {
                        break;
                    }

                }
                data[j] = temp;

            }
            System.out.println(Arrays.toString(data));

        }
    }
    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     * @param numbers
     */
    public static void selectSort(int[] numbers)
    {
        int size = numbers.length; //数组长度
        int temp = 0 ; //中间变量

        for(int i = 0 ; i < size ; i++)
        {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数  j 要从i 开始算起
            for(int j = i ; j < size; j++)
            {
                if(numbers[j] < numbers[k])
                {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;

            System.out.println(Arrays.toString(numbers));
        }
    }


}
