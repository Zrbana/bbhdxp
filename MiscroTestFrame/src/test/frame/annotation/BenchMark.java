package test.frame.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解用来标记需要测试的方法
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //针对要测试的方法
public @interface BenchMark {

}
