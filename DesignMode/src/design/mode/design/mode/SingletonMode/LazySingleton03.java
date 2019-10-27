package design.mode.design.mode.SingletonMode;
        //双重加载
/**
 *优缺点:
 * 1.多重检查是多咸亨==线程开发中经常使用到的，如下代码所示，
 * 进行了两次if(instance==null)检查，就保证了线程安全。
 * 2.这样，实例化代码只用执行一次，后面再次访问时，
 * 直接return 实例化对象，避免反复的方法同步。
 * 3.线程安全，延迟加载，效率较高
 * 结论：实际开发中，推荐使用这种方式
 */


public class LazySingleton03 {
    private static volatile LazySingleton03 instance;
    private LazySingleton03(){
    }
    /**提供一个静态的公用方法，加入双重检查代码，解决线程安全问题，
     *同时解决懒加载问题
     */
    public static LazySingleton03 getInstance(){
        if(instance==null){
            synchronized (LazySingleton03.class){
                if(instance==null){
                    instance= new LazySingleton03();
                }
            }
        }
        return instance;
    }
}
