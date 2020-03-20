package com.zn.apply;
//定义购物车标准
public interface IShopCar {
    void add(IGoods goods);//添加商品信息
    void delete(IGoods goods);//删除商品
    Object[] getAll();//获得购物车中全部信息
}
