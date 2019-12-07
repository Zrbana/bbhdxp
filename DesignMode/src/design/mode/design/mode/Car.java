package design.mode.design.mode;

public class Car implements Vehicle {
    public Car(){
        System.out.println("create car");
    }
    @Override
    public void run() {
        System.out.println("run car");
    }
}
