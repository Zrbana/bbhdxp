package Proxy.Subject;


import java.lang.reflect.Method;

public class MessageExtend implements MethodInterceptor {

    private final Object target;

    public MessageExtend(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("扩展的代码(B)，此处省略。。。。1w");
        Object returnValue= method.invoke(target,args);//业务对象自己的方法
        System.out.println("扩展的代码(A)，此处省略。。。。1w");
        return returnValue;
    }
}
