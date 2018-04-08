package com.jalon;

import java.util.function.Function;

/**
 * Created by Jalon on 08/04/2018.
 */
public class FunctionSample {
    //API which accepts an implementation of
    //Function interface

    public static void main(String[] args) {

        int incr = 20;  int myNumber = 10;
        modifyTheValue(myNumber, val-> val + incr );
        //  ==> �ȼ���
        modifyTheValue(myNumber, new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer + incr ;
                    }
                }
        );

        //myNumber = 15;  modifyTheValue(myNumber, val-> val * 10);
        //modifyTheValue(myNumber, val-> val - 100);
        //modifyTheValue(myNumber, val-> "somestring".length() + val - 100);
    }


    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){

        // function �ӿڵ�ʵ�֣�����valueToBeOperated ���в���
        int newValue = function.apply(valueToBeOperated);

        /*
         * Do some operations using the new value.
         */
        System.out.println(newValue);

    }
}
