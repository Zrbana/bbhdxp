package design.mode.design.mode.SingletonMode;

/**
 * 优缺点：
 * 1.解决了线程不安全的问题
 * 2.效率太低了，每个线程在想获得类的实例的时候，
 * 执行getInstance()方法都要进行同步。而其实这个方法
 * 只执行一次代码就够了，后面的要想获得实例，直接return就行。
 * 结论：在实际开发中，不推荐使用这种方式
 */
public class LazySingleton02 {
    private static LazySingleton02 instance = null;
    private LazySingleton02(){}
    public static synchronized  LazySingleton02 getInstance(){
                   if (instance == null) {
                instance = new LazySingleton02();
            }
            return instance;
        }

}
