package design.mode.design.mode.SingletonMode;

/**懒汉式（线程不安全）
 * 优缺点：
 * 1.起到了Lazy Loading的效果，但是只能在单线程下使用
 * 2.如果在多线程情况下，一个线程进入了if(instance==null)语句块，
 * 还未来得及创建实例，另一个线程也通过了这个判断语句，就会产生
 * 多个实例
 * 结论：在实际开发中不要使用这种方式
 */
public class LazySingleton {
    private  static LazySingleton instance = null;
    private LazySingleton(){}

    /**
     * 提供一个静态的公有方法，当使用该方法时，再去创建实例
     * @return instance
     */
    //线程不安全
    public static LazySingleton getInstance(){
        if(instance==null){
                instance = new LazySingleton();
        }
        return instance;
    }


}
 class Test{
     public static void main(String[] args) {
         LazySingleton instance1 =LazySingleton.getInstance();
         LazySingleton instance2 =LazySingleton.getInstance();
         System.out.println(instance1==instance2);
         System.out.println("instanc.hashCode="+instance1.hashCode());
         System.out.println("instanc.hashCode="+instance2.hashCode());
     }
}