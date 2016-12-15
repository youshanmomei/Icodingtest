package org.hy.test.c3;

/**
 * Created by andy on 2016/12/15.
 * 用Java代码实现：求1+2+3+...+n，不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 * 可以用 + 号
 * 核心思想是迭代
 */
public class CalculateWithoutOperator {
    public static void main(String[] args) {
        int n=99;
//        int n=5;
        int result=calculate(n);
        System.out.print(result);
    }

    static int calculate(int n){
        int result=0;
        boolean flag=false;
        //No.1
        //开始写代码，不用操作符计算1+2+……+n，可以用+号
        return n>0?n+calculate(n-1):0;


        //end_code
    }
}
