package org.hy.test.c4;

/**
 * Created by andy on 2016/12/15.
 * 用java代码使用内部静态类实现单例模式
 */
public class SingletonTest {
    private static String string;

    public SingletonTest(){}

    private SingletonTest(String parameterString){
        string=parameterString;
    }
    //No.1
    //开始写代码，使用内部静态类实现单例模式
    public static SingletonTest getInstance(String parameterString){
        string = parameterString;
        return innerStaticClass.instance;
    }

    static class innerStaticClass{
        private static SingletonTest instance = new SingletonTest();
    }
    //end_code
    public void getString(){
        System.out.println(string);
    }

    public static void main(String args[]){
        SingletonTest singleton1 = SingletonTest.getInstance("hello world");
        SingletonTest singleton2 = SingletonTest.getInstance("apple");
        singleton1.getString();
        singleton2.getString();
        System.out.println(singleton1 == singleton2);
    }
}
