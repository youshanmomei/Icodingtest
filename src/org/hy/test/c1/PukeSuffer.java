package org.hy.test.c1;

import org.junit.Test;

import java.util.Random;

/**
 * Created by andy on 2016/12/9.
 * 写一个扑克牌的小程序，对52张扑克牌进行排序输出（不包含大小王）
 * 1-13     红桃
 * 14-26    黑桃
 * 27-39    草花
 * 40-52    方块
 */
public class PukeSuffer {

    @Test
    public void test(){
        System.out.println("重新排序的结果是：");
        System.out.println("-------------------------");
        pkShuffle();
    }

    public void pkShuffle(){
        int[] pk = new int[52];
        for (int i=1; i<53; i++) {
            pk[i-1] = i;
        }

        //1.随机选出0-51个数
        //2 用一个数组去记录每次选择的数,如果存在，就重选。老数组中的那个数没有被使用过就加入，并将结果置为0

        int[] pk_n = new int[52];
        Random random = new Random();
//        int rI = random.nextInt(52);//[0,52)

        for(int i=0; i<pk_n.length; i++){
            boolean flag = true;
            while (flag) {
                int rI = random.nextInt(52);//[0,52)
                if(pk[rI]==0){
                    continue;
                }else {
                    pk_n[i] = pk[rI];
                    pk[rI] = 0;
                    flag = false;
                }
            }

        }


        String showArr = "[";
        for (int i=0; i<pk_n.length-1; i++) {
            showArr += pk_n[i]+", ";
        }
        showArr += pk_n[pk_n.length-1] + "]";
        System.out.println(showArr);

    }

    //-----------------------------
    @Test
    public void webTest() {
        final int cardTotal = 52;
        int[] card = new int[cardTotal + 1];
        for (int i = 1; i <= cardTotal; i++)
            card[i] = i;
        //No.1
        //开始写代码，模仿洗扑克牌，实现对52张扑克牌的乱序排列（不包括大小王）
        int[] pk_n = new int[52];
        Random random =  new Random();
        for (int i = 1; i <= pk_n.length; i++){
            boolean flag = true;
            while(flag){
                int rI = random.nextInt(53);
                if(rI==0 || card[rI]==0){
                    continue;
                }else{
                    pk_n[i-1] = card[rI];
                    card[rI]=0;
                    flag=false;
                }

            }

        }
        //end_code
        for (int i = 1; i < pk_n.length; i++) {
            //No.2
            //开始写代码，用switch语句，以例如“梅花K”的形式输出乱序排列后的结果
            int remain = pk_n[i] % 13;
            switch(pk_n[i] / 13){
                case 0:
                    System.out.println("红桃:" + remain);
                    break;
                case 1:
                    System.out.println("黑桃：" + remain);
                    break;
                case 2:
                    System.out.println("草花：" + remain);
                    break;
                case 3:
                    System.out.println("方块：" + remain);
                    break;
                default:
                    break;
            }

            //end_code
        }
    }
}
