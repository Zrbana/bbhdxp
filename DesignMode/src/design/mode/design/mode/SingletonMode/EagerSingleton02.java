package design.mode.design.mode.SingletonMode;
//优缺点：与第一种写法 类似，只不过将实例化过程放在静态代码块中。
public class EagerSingleton02 {

        private static EagerSingleton02 instance;

        private EagerSingleton02() {
        }

        static {
            //在静态代码块中创建单例对象
            instance = new EagerSingleton02();
        }

        //创建一个公共的静态方法，返回实例对象
        public static EagerSingleton02 getInstance() {
            return instance;
        }

}
