package design.mode.design.mode.SingletonMode;

/**
 * 枚举方式实现单例
 * 优缺点：
 * 1.借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题。
 * 还能防止反射重新构建新的对象
 */
public class SingletoTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance1==instance2);
    }

}
enum Singleton{
        INSTANCE;//属性
        public void method(){
        }
    }
