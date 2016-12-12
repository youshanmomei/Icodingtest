package org.hy.test.c2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2016/12/12.
 * 用java代码实现查并集
 */
public class ConSet {
    private static int[] member;

    static void MakeSets(String[][] string){
        int count = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<string.length; i++) {
            for (int j=0; j<string[i].length;j++) {
                if (map.get(string[i][j]) == null) {
                    map.put(string[i][j], count);
                }
            }
        }
//        ConSet.map = map;
        member = new int[count];
        for (int i=0; i<count; i++) {
            member[i]=i;
        }
    }
}
