package design.mode.design.mode.SingletonMode;

/**
 * 静态内部类
 * 1.外部无法访问静态内部类Holder,只有当调用Singleton.getInstance方法时。
 * 才能得到单例对象
 * 2.instance对象初始化的时机并不是在单例类Singleton被加载的时候，
 * 而是在调用getInstance方法，使得静态内部类Holder被加载的时候。
 * 因此这种实现方式是利用classloader的加载机制来实现懒加载，
 * 并保证构建单例的线程安全。
 */
public class StaticInnerClass {

}
class Singleton01{
  private Singleton01(){}
  private static class Holder{
      private static Singleton01 instance = new Singleton01();
  }
  public static Singleton01 getInstance(){
      return Holder.instance;
  }

}

