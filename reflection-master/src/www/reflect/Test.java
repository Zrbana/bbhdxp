package www.reflect;

import java.util.Date;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        //方法一：Object类的getClass() 方法
        //Date date = new Date();
        //Class cls = date.getClass();
        //System.out.println(cls.getName());//java.util.Date

        //方法二：Class类的静态方法forName();
        //Date date = new Date();
        //String className = "java.util.Date";
        //Class cls =  Class.forName(className);


        //方法三：T.class
        Class cls = Date.class;
        System.out.println(cls.getName());//java.util.Date
        Class cls2 = int.class;
        System.out.println(cls2.getName());//int
        Class cls3 = Double[].class;
        System.out.println(cls3.getName());//[Ljava.lang.Double;
    }
}

