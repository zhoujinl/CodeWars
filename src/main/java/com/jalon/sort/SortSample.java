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
 * ð������  ������ð����ȥ
 * �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û�����������
 * ������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * ����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
 * @param numbers ��Ҫ�������������
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
                if(numbers[j] > numbers[j+1])  //��������λ��
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
    /**
     * ��������
     *
     * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
     * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
     * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��
     * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��
     * ����Ԫ�ز��뵽��λ����
     * �ظ�����2
     * @param numbers  ����������
     */
    public static void simpleInsertSort(int[] numbers)
    {
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < numbers.length ; i++)
        {
            temp = numbers[i];
            //����temp��ǰ���ֵС����ǰ���ֵ����
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
    1������˼�룺
    �Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬴����������еļ�¼����������ʱ���ٶ�ȫ���¼��������ֱ�Ӳ�������
    2������������

    <code>
    1��ѡ��һ����������t1��t2������tk������ti>tj��tk=1��
    2�����������и���k�������н���k ������
    3��ÿ�����򣬸��ݶ�Ӧ������ti�����������зָ�����ɳ���Ϊm �������У��ֱ�Ը��ӱ����ֱ�Ӳ������򡣽���������Ϊ1 ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
    </code>
     */
    public static void shellSort(int[] data)
    {
        int j = 0;
        int temp = 0;
        //ÿ�ν���������Ϊԭ����һ��
        for (int increment = data.length / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.length; i++)
            {
                temp = data[i];
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp < data[j - increment])//�����С������ֻ���޸�����
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
     * ѡ�������㷨
     * ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��
     * �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��
     * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
     * @param numbers
     */
    public static void selectSort(int[] numbers)
    {
        int size = numbers.length; //���鳤��
        int temp = 0 ; //�м����

        for(int i = 0 ; i < size ; i++)
        {
            int k = i;   //��ȷ����λ��
            //ѡ���Ӧ���ڵ�i��λ�õ���  j Ҫ��i ��ʼ����
            for(int j = i ; j < size; j++)
            {
                if(numbers[j] < numbers[k])
                {
                    k = j;
                }
            }
            //����������
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;

            System.out.println(Arrays.toString(numbers));
        }
    }


}
