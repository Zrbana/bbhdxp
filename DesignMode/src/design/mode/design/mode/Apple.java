package design.mode.design.mode;

public class Apple  implements Food{
    public Apple(){
        System.out.println("create apple");
    }
    @Override
    public void eat() {

        System.out.println("eating apple");
    }
}
