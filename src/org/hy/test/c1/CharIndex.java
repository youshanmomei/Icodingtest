package org.hy.test.c1;


import org.junit.Test;

/**
 * Created by andy on 2016/12/9.
 */
public class CharIndex {

    @Test
    public void iTest() {
        int index = isearchCharIndex("aabbccddgff");
        System.out.println("不重复的是：" + index);
    }


    public static int isearchCharIndex(String text) {
        int length = 0;

        if (null == text || (length = text.length()) == 0) {
            return 0;
        }
        char currentChar;
        char nextChar;

        //No.1
        //输入一个字符串，找到不重复的第一个
        for (int i = 0; i < length; i++) {
            boolean rep = false;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                if (text.charAt(i) == text.charAt(j)) {
                    rep = true;
                    break;
                }
            }
            if (!rep) {
                return i;
            }
        }

        //the method is to find the repeat one
//        for(int i=0; i<length; i++){
//            for (int j=0; j<i; j++) {
//                if (text.charAt(i) == text.charAt(j)) {
//                    return i;
//                }
//            }
//        }

        //end_code

        return -1;
    }

}
