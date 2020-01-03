package design.mode.iterator;

/**
 * 作用：通过getName获取书的名字
 */
public class Book {
    private String name;
    public Book(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
