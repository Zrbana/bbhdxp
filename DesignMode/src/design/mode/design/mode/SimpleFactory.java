package design.mode.design.mode;

/**
 * 简单工厂模式：
 * 主要有一个静态方法，用来接收参数，并根据参数来决定返回实现统一接口的不同类的实例
 *
 * 角色：
 * 1.工厂类角色：产生不同的具体产品
 * 2.抽象产品：接口或抽象类
 * 3.具体产品：工厂类创建的具体实例对象
 */
public class SimpleFactory {
    public static Product createFactory(String productName){
        if("washer".equals(productName)){
            return new Washer();
        }else if("Aircondition".equals(productName)){
                return new AirCondition();
            }else{
            return (Product) new Exception();
        }
    }
}
