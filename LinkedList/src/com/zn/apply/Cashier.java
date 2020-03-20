package com.zn.apply;

/**
 * @ClassName Cashier
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/20 23:08
 */


public class Cashier {
    private IShopCar shopCar;
    public Cashier(IShopCar shopCar){
        this.shopCar = shopCar;
    }
    public double allPrice(){
        double all = 0.0;
        Object result[] = this.shopCar.getAll();
        for(Object obj:result){
            IGoods goods = (IGoods)obj;
            all += goods.getPrice();
        }
        return all;
    }
    public int allCount(){
        return this.shopCar.getAll().length;
    }
}
