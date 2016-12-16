package org.hy.test.c5;

/**
 * Created by andy on 2016/12/16.
 * 用java代码实现二分查找，要求用递归和非递归两种方法实现
 */
public class BiSearchTest {
    //No.1
    //开始写代码，用递归和非递归两种方式实现二分查找，补充完整BiSearchNonRecursive和BiSearchRecursive方法
    public static int BiSearchNonRecursive(int array[], int low, int length, int key)// 非递归
    {
        int high = length - 1;
        int sub = 0;

        if(key>array[high] || array[key]<array[low]){
            return -1;
        }

        while(length/2>0){
            sub = (low+high)/2;
            if (key==array[high]) {
                return high;
            } else if (key==array[low]) {
                return  low;
            } else if (key==array[sub]) {
                return sub;
            } else if (key>array[sub]) {
                low = sub;
            } else if (key < array[sub]) {
                high = sub;
            }
        }

        return -1;

    }

    public static int BiSearchRecursive(int array[], int low, int high, int key)// 递归
    {
        if(key>array[high] || array[key]<array[low]){
            return -1;
        }

        int sub = (low+high+1)/2;
        if (key==array[high]) {
            return high;
        } else if (key==array[low]) {
            return  low;
        } else if (key==array[sub]) {
            return sub;
        } else if (key>array[sub]) {
            low = sub;
            return BiSearchRecursive(array, low, high, key);
        } else if (key < array[sub]) {
            high = sub;
            return BiSearchRecursive(array, low, high, key);
        }

        return -1;
    }
    //end_code
    public static void main(String[] args) {
        int number[] = { 1, 2, 3, 4, 5, 6, 7 };
        int index;
        int key;
        key = 4;
        index = BiSearchNonRecursive(number, 0, number.length, key) + 1;
        if (index == 0)
            System.out.println("不存在");
        else
            System.out.println("目标数字" + key + "在数组中第" + index + "位");
        key = 5;
        index = BiSearchRecursive(number, 0, number.length - 1, key) + 1;
        if (index == 0)
            System.out.println("不存在");
        else
            System.out.println("目标数字" + key + "在数组中第" + index + "位");
    }
}
