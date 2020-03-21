package com.zn.number;

/**
 * @ClassName NumberServiceImpl
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:09
 */


public class NumberServiceImpl implements INumberService {
    @Override
    public int[] stat(int count) {
        int result[]  = new int[2];//定义返回的结果
        int data[] = new int[count];
        for(int x =0;x < data.length;x++){
            data[x] = InputUtil.getInt("请输入第"+(x+1)+"个数字：");
        }
        result[0]=data[0];   //最大值
        result[1]=data[0];   //最小值
        for(int x = 0 ;x < data.length; x ++) {
            if(data[x] > result[0]) {
                result[0] = data[x];
            }
            if(data[x] < result[1]) {
                result[1] = data[x];
            }
        }
        return result;
    }
}
