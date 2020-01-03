package design.mode.adpater;

public class Main {
    public static void main(String[] args) {
        Print p = new printBanner("hello");
        p.printStrong();;
        p.printWeak();
    }
}
