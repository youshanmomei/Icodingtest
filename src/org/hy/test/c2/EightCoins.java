package org.hy.test.c2;

import org.junit.Test;

/**
 * Created by andy on 2016/12/12.
 * 有8枚银币，其中一枚是假币，其重量不同于真币，但不知是较轻或者是较重，如何使用天平以最少的比较次数决定出假币，并得知假币比真币较轻或是较重
 * <p>
 * 单就求假币的问题是不难，但问题限制使用最少的比较次数，所以我们不能以单纯的回圈比较来求解，我们可以使用决策树（decision tree），使用分析与树状图来协助求解。
 * 一个简单的状况是这样的，我们比较a+b+c与d+e+f ，如果相等，则假币必是g或h，我们先比较g或h哪个较重，如果g较重，再与a比较（a是真币），如果g等于a，则g为真币，则h为假币，由于h比g轻而 g是真币，则h假币的重量比真币轻。
 */
public class EightCoins {
    private int[] coins;

    public EightCoins() {//设置银币重量
        coins = new int[8];
        for (int i = 0; i < 8; i++) {
            coins[i] = 10;
        }
    }

    //设置假币重量
    public void setFake(int weight) {
        coins[(int) (Math.random() * 7)] = weight;
    }

    //输出8个银币的重量
    public void printCoins() {
        for (int i = 0; i < 8; i++) {
            System.out.print(coins[i] + " ");
        }
    }

    protected void compare(int i, int j, int k) {
        if (coins[i] > coins[k]) {
            System.out.print("\n假币 " + (i + 1) + " 较重");
        } else {
            System.out.print("\n假币 " + (j + 1) + " 较轻");
        }
    }

    //检测假币
    public void fake() {
        //No.1
        if (coins[0] + coins[1] + coins[2] == coins[3] + coins[4] + coins[5]) {
            if (coins[7] > coins[6]) {
                compare(7, 6, 1);
            } else {
                compare(6, 7, 1);
            }
        }else if(coins[0] + coins[1] + coins[2] > coins[3] + coins[4] + coins[5]){
            if (coins[0] + coins[3] > coins[1]+coins[4]){ //说明2和5是相等的，且要么a过大，要么b过小——用的不等式的性质
                compare(0,  4, 5);
            }else if (coins[0] + coins[3] == coins[1]+coins[4]){
                compare(2,5,0);
            }else{
                compare(1,3,5);
            }
        }else{
            if(coins[0] + coins[3] > coins[1]+coins[4]){
                compare(3,1,5);
            }else if(coins[0] + coins[3] == coins[1]+coins[4]){
                compare(5,2,0);
            }else {
                compare(0,4,2);
            }
        }
        //end_code
    }

    @Test
    public void run() {
        EightCoins eightCoins = new EightCoins();
        eightCoins.setFake(5); //设置假银币重量为5
        eightCoins.printCoins(); //输出当前8个银币的重量
        eightCoins.fake();
    }


}
