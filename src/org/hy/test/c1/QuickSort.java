package org.hy.test.c1;

import org.junit.Test;

/**
 * Created by andy on 2016/12/9.
 */
public class QuickSort {


    @Test
    public void changeSort(){
        int[] a = new int[]{2,4,3,5,1,8,7,6};

        for (int i=0; i<a.length-1; i++) {
            int min=i;

            for (int j=i+1; j<a.length; j++) {
                if(a[j]<a[min]){
                    min = j;
                }
            }

            if(min!=i){
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }

        for (int i : a) {
            System.out.print( i + " ");
        }
    }

    //answer
    public static void main(String[] args) {
        int[] list={49,38,65,97,76,13,27,14,10};
        //No.1
        //开始写代码，用java实现选择排序
        if (list==null || list.length==0) {  	//判断数组是否存在或为空
            return;
        }

        for(int i=0; i<list.length; i++){
            int min=i;

            for(int j=i+1; j<list.length; j++){
                if(list[j]<list[min]){
                    min = j;
                }
            }

            if(min!=i){
                int tmp = list[min];
                list[min] = list[i];
                list[i] = tmp;
            }
        }

        for(int i:list){
            System.out.print(i+" ");
        }

        //end_code
    }
}
