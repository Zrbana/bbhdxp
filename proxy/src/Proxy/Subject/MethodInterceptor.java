package Proxy.Subject;

import java.lang.reflect.Method;

public interface MethodInterceptor {
    Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable;
}
