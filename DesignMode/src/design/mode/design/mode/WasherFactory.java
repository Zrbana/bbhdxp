package design.mode.design.mode;

public class WasherFactory implements Factory{

    @Override
    public Product create() {
        return new Washer();
    }
}
