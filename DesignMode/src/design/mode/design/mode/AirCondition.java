package design.mode.design.mode;

/**
 * 具体实现类
 */
public class AirCondition implements Product {
    public AirCondition(){
        System.out.println("AirCondition is created!");
    }


    @Override
    public void act() {
        System.out.println("制冷");
    }
}
