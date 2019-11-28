//@ClassAnnotation(value = "类级别的注解")
@ClassAnnotation("类级别的注解")
class A {
}

public class Main {
    public static void main(String[] args) {
        ClassAnnotation annotation = A.class.getAnnotation(ClassAnnotation.class);
        if (annotation != null) {
            System.out.println(annotation.value());
        }
    }
}
