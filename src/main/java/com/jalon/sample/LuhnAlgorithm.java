package com.jalon.sample;

import java.util.Arrays;

/**
 * Created by JinQiu on 2018/4/7.
 */

/**
 * Description:
 In this Kata, you will implement the Luhn Algorithm, which is used to help validate credit card numbers.

 Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.

 Here is the algorithm:

 Double every other digit, scanning from right to left, starting from the second digit (from the right).

 Another way to think about it is: if there are an even number of digits, double every other digit starting with the first; if there are an odd number of digits, double every other digit starting with the second:

 1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]

 12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]

 891 ==> [8, 9*, 1] ==> [8, 18, 1]
 If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting 9 from it):

 [8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]

 or:

 [8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]
 Sum all of the final digits:

 [8, 9, 1] ==> 8 + 9 + 1 = 18
 Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.

 18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number
 */
public class LuhnAlgorithm {
    public static boolean validate(String n){
        String sni = new StringBuffer(n).reverse().toString();
        String[] ss = sni.split("");
        for(int i =0;i < ss.length ;i++){
            if( i%2 == 1){
                int tmp = Integer.valueOf(ss[i])*2;
                if( tmp > 9){
                    tmp = Arrays.stream(String.valueOf(tmp).split("")).
                            mapToInt(Integer::parseInt).
                            reduce(0,(a,b) -> a+b);    // sum()
                }
                ss[i] = String.valueOf(tmp);
            }
        }
        int lsi =  Arrays.asList(ss).stream().mapToInt(x -> Integer.parseInt(x)).sum() % 10;
        if(lsi == 0) return true;
        return false;
    }

    public static boolean validate1(String str){
        // TODO: solution
        int[] digits = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < digits.length; i++){
            if (i % 2 == 1) {
                digits[digits.length - i - 1] *= 2;
            }
            sum+= digits[digits.length - i - 1] > 9 ? digits[digits.length - i - 1] - 9 : digits[digits.length - i - 1];
        }
        return sum % 10 == 0;
    }
    //重点关注   map(integer -> ((flag[0] ^= true) ? (integer * 2 - 1) % 9 + 1 : integer))
    public static boolean validate3(String n) {
        final boolean[] flag = {(n.length() & 1) == 1};
        return Arrays.stream(
                n.split(""))
                .map(Integer::parseInt)
                .mapToInt(value -> value)
                .map(integer -> ((flag[0] ^= true) ? (integer * 2 - 1) % 9 + 1 : integer))
                .sum() % 10 == 0;
    }
    static boolean validate4(final String line) {
        boolean otherDigit = false;
        int sum = 0;

        // From the rightmost digit, which is the check digit, moving left
        for (int i = line.length() - 1; i >= 0; --i) {
            // convert char to number
            int digit = line.charAt(i) - '0';

            // double the value of every second digit
            if (otherDigit) {
                digit *= 2;
            }
            otherDigit ^= true;

            // if the product of this doubling operation is greater than 9
            // (for example, 7x2=14), then sum the digits of the products
            // (for example, 12:1+2=3, 14:1+4=5)
            if (digit > 9) {
                digit = digit / 10 + digit;
            }

            // Take the sum of all the digits
            sum += digit;
        }

        // If the sum modulo 10 is equal to 0 (if the sum ends in zero) then,
        // according to the Luhn formula, the number is valid; otherwise, it is not valid.
        return sum % 10 == 0;
    }
}
