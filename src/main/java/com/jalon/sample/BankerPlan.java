package com.jalon.sample;

/**
 * Created by JinQiu on 2018/4/17.
 */
public class BankerPlan {

    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        for ( int year =1; year < n ; year ++) {
            f0 = (int)(f0*(1+p/100)) - c0;
            c0 = (int)(c0*(1+i/100));
        }
        return f0 > 0 ? true:false;
    }

    public static boolean fortune2(int f0, double p, int c0, int n, double i) {
        while (n > 0 && f0 >= 0){
            f0 += p/100 * f0 - c0;
            c0 += i/100 * c0;
            n--;
        }
        return n == 0;
    }

}
