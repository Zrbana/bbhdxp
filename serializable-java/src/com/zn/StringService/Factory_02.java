package com.zn.StringService;

/**
 * @ClassName Factory_02
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 22:33
 */


public class Factory_02 {
    private Factory_02() {}
    public static IStringService getInstance() {
        return new StringServiceImpl();
    }
}
