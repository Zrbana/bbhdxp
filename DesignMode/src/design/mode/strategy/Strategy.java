package design.mode.strategy;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
