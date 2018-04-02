package com.jalon.sample;
/**
 * Created by Jalon on 02/04/2018.
 */
class TriangleTester{
    public static boolean isTriangle(int a, int b, int c){
        if( (a<=0 ) || (b<=0) ||  (c<=0) )return false;
        if ((a+b>c) && (a+c>b) && (b+c>a)  )return true;
        return false;
    }
}