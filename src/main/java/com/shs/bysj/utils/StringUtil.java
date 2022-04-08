package com.shs.bysj.utils;

import java.util.Random;

/**
 * @Author: shs
 * @Data: 2022/4/8 11:37
 */
public class StringUtil {

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}