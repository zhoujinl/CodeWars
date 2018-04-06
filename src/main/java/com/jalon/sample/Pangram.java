package com.jalon.sample;

/**
 * Created by JinQiu on 2018/4/6.
 * 判断一句话里面是不是包含了26个字母
 */

public class Pangram {

    public boolean check(String sentence) {
        //code 正则表达式
        long chout = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase().chars().distinct().count();
        if (chout == 26) return true;
        return false;
    }

    public boolean check1(String sentence){

        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

    //效率更高
    public boolean check3(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

    }

}
