package design.mode.design.mode;

/**
 * 具体实现类
 */
public class Washer implements Product {
    public Washer(){
        System.out.println("washer is created!");
    }
    @Override
    public void act() {
        System.out.println("wash clothes");
    }
}
