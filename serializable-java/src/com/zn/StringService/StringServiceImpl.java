package com.zn.StringService;

/**
 * @ClassName StringBuffer
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:31
 */


public class StringServiceImpl implements IStringService {
    private StringBuffer data = new StringBuffer();
    @Override
    public void append(String s) {

        this.data.append(s).append("|");
    }

    @Override
    public String[] reverse() {
        String result [] = data.toString().split("\\|");
        int center = result.length / 2;
        int head = 0;
        int tail = result.length - 1;
        for (int x = 0; x < center; x++) {
            String tmp = result[head];
            result[head] = result[tail];
            result[tail] = tmp;
        }
        return result;

    }
}
