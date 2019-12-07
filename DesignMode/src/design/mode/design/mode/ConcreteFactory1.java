package design.mode.design.mode;

/**
 * 具体工厂类生产汽车和苹果
 */
public class ConcreteFactory1 implements Factory {
    @Override
    public Product create() {
        return null;
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
