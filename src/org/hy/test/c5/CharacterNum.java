package org.hy.test.c5;

/**
 * Created by andy on 2016/12/16.
 * ﻿用java代码实现输入一串字符串，统计其中的数字、英文、空格、其他字符个数
 */
public class CharacterNum {
    public static void main(String[] args) {
        int digital = 0;//数字个数
        int character = 0;//英文个数
        int other = 0;//其他字符个数
        int blank = 0;//空格个数
        char[] chars = null;
        String string = "djfiepqo ioghr4 8758495 7123hr37hfjW$@@$@^%!";
        System.out.println("这是任意一串字符：" + string);
        chars = string.toCharArray();
        //No.1
        //开始写代码，计算任意一串字符中的数字个数、英文字母个数、空格个数和其他字符个数
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                digital++;
            } else if (Character.isLetter(c)){
                character++;
            } else if (Character.isWhitespace(c)) {
                blank++;
            } else {
                other++;
            }
        }
        //end_code
        System.out.println("数字个数: " + digital);
        System.out.println("英文字母个数: " + character);
        System.out.println("空格个数: " + blank);
        System.out.println("其他字符个数:" + other);
    }
}
