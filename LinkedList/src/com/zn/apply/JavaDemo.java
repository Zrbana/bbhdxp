package com.zn.apply;

/**
 * @ClassName JavaDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/20 23:13
 */


public class JavaDemo {
    public static void main(String args[]) {
        IShopCar car = new ShopCar();
        car.add(new Book("Java开发",79.8));
        car.add(new Book("Oracle ",89.8));
        car.add(new Bag("小强背包",889.8));
        Cashier cas = new Cashier(car);
        System.out.println("总价格："+cas.allPrice ()+"、购买总数量："+cas.allCount ());
    }
}
