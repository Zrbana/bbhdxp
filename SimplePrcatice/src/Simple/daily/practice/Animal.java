package Simple.daily.practice;

public class Animal {
    public String name;
    public int age;
    public String colour;
    public String voice;

    public Animal() {
        System.out.println("我是Animal类无参数的构造方法");
    }

    public Animal(String name) {
        this.name=name;
    }
    public void shout(){
        System.out.println("我是"+name+",我会"+voice+"叫");
    }
}
