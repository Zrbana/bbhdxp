package design.mode.design.mode;

public class Plane implements Vehicle {
    public Plane(){
        System.out.println("plane");
    }
    @Override
    public void run() {
        System.out.println("big plane");
    }
}
