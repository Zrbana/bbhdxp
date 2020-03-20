package com.zn.apply;

import com.zn.test.ILink;
import com.zn.test.LinkImpl;

/**
 * @ClassName ShopCar
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/20 23:04
 */


public class ShopCar implements IShopCar {
    ILink<IGoods> allGoodseses = new LinkImpl<IGoods>();
    @Override
    public void add(IGoods goods) {
        this.allGoodseses.add(goods);
    }

    @Override
    public void delete(IGoods goods) {
    }

    @Override
    public Object[] getAll() {
        return this.allGoodseses.toArray();
    }
}
