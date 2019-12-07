package design.mode.design.mode;

/**
 * 客户端
 * 优点：客户端可以免除直接创建产品对象的责任，而仅仅负责消费对象就可以了，这种做法就实现了对职责权利的分割，有利于优化结构
 *
 *  
 *
 * 缺点：
 *
 * 1、每次想要增加一种新产品的时候，都必须修改SimpleFactory的原代码
 * 2、如果产品过多，代码逻辑很复杂，整个系统都依赖SimpleFactory，一旦SimpleFactory出现问题，系统将不能工作。这点在工厂模式进行了改进。
 */
public class Client {
    public static void main(String[] args) {
        //简单工厂客户端
        try{
            SimpleFactory.createFactory("Washer");
            SimpleFactory.createFactory("AirCondition");
            SimpleFactory.createFactory("TV");
        }catch (Exception e){
            System.out.println("no product");
        }


        /** 工厂模式客户端
         * 优点：每个产品都有自己对应的工厂类，互不干涉，增加或修改都不影响其他的产品
         *
         * 缺点：产品越多，需要创建的工厂类越多
         *  Product product;
         * 		product = new WasherFactory().create();
         * 		product.act();
         * 		product = new AirConditionFactory().create();
         * 		product.act();
         */


        /**
         * 抽象工厂：
         * IFactory factory1 = new ConcreteFactory1();
         * 		factory1.createVehicle().run();
         * 		factory1.createFood().eat();
         *
         * 		IFactory factory2 = new ConcreteFactory2();
         * 		factory2.createVehicle().run();
         * 		factory2.createFood().eat();
         * 
         */
    }
}
