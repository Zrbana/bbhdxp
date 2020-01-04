package design.mode.factory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory() ;
        Product card1 = factory.create("1号");
        Product card2 = factory.create("2号");
        Product card3 = factory.create("3号");
        card1.use();
        card2.use();
        card3.use();
    }
}
