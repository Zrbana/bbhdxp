package design.mode.design.mode.SingletonMode;

/**
 * 饿汉式写法1单例模式（静态常量）
 * 优缺点：
 * 1.优点：写法简单，在类加载时完成实例化，避免了线程同步问题
 * 2.缺点：在类加载时就完成实例化，没有达到Lazy Loading的效果。
 * 如果从始至终没有使用过这个实例，则会造成内存浪费。
 *
 * 结论：这种单例模式可用，但是可能造成内存浪费
 *
 */
public class EagerSingleton01 {
    //私有构造方法 防止被New
    private EagerSingleton01(){ }
    //私有静态变量
    private final static EagerSingleton01 instance = new EagerSingleton01();
    public static EagerSingleton01 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        EagerSingleton01 test1 = EagerSingleton01.getInstance();
        EagerSingleton01 test2 = EagerSingleton01.getInstance();
        System.out.println(test1==test2);//true
    }
}
