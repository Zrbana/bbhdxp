package design.mode.abstractFacory;

public abstract class Item {
    protected String caption;//项目的标题
    public Item(String caption){
        this.caption = caption;
    }
    public abstract String makeHTML();
}
