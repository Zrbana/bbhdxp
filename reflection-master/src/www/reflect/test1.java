package www.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> klass = methodClass.class;
        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method = klass.getMethod("add",int.class,int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method.invoke(obj,1,4);
        System.out.println(result);
    }
}

class methodClass{
    public static int a = 1;
    public int add(int x, int y){
        return x+y;
    }
    public int sub(int x,int y){
        return x-y;
    }
}
