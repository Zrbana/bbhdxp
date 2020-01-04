package design.mode.builder;

import java.io.IOException;

public abstract class Builder {
    public abstract void makeTitle(String title) throws IOException;
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

}
