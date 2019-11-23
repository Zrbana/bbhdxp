package data.struct.apply;

import java.util.Arrays;

//利用二维数组做一个彩票号码产生器
public class lotteryNumberGenerator {
    public static void main(String[] args) {
        int count = 1000000;//产生随机数的次数
        int randomNum;//产生的随机号码
        int[][] array = new int[2][42];//放置随机数的数组

        //将产生的随机数放入数组
        while(count-->0){
            randomNum =(int) (Math.random()*42);
            array[0][randomNum]++;
            array[1][randomNum]++;
        }
        //对array[0]做排序
        Arrays.sort(array[0]);
        //找出最大的六个数字号码
        for(int i=41;i>(41-6);i--){
            //逐一检查数字相同者
            for(int j = 41;j>=0;j--){
                if(array[0][i]==array[1][j]){
                    System.out.println("随机数号码"+(j+1)+"出现"+array[0][i]+"次");
                    array[1][j]=0;//将找到的数值次数归零
                    break;
                }
            }
        }
    }
}
