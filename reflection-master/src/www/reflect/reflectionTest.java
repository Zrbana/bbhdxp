package www.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program use reflection to print all features of a class
 */
public class reflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {

        String name;
        if(args.length>0)
            name = args[0];
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name:");
            name = in.next();
        }

        Class cls = Class.forName(name);
        Class superClass = cls.getSuperclass();
        String modifiers = Modifier.toString(cls.getModifiers());//获得当前类的标识符
        if(modifiers.length()>0){
            System.out.print(modifiers+" ");
        }
        System.out.print("class "+name);
        if(superClass!=null && superClass!=Object.class){
            System.out.print(" extends "+superClass.getName());
        }
        System.out.print("\n{\n");
        printConstructor(cls);
        System.out.println();
        printMethods(cls);
        System.out.println();
        printField(cls);
        System.out.println("}");
    }

    public static void printConstructor(Class cls){
        Constructor[] constructors = cls.getConstructors();

        for(Constructor c:constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");


            //print parameter types
            Class[] parameterType = c.getParameterTypes();
            for(int j = 0;j<parameterType.length;j++){
                if(j>0){
                    System.out.print(",");

                }
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cls){
        Method[] methods = cls.getDeclaredMethods();
        for(Method m:methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");

            //print modofiers,return type and method
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
                System.out.print(retType.getName()+""+name+"(");
                Class[] paramTypes = m.getParameterTypes();
                for(int j = 0;j<paramTypes.length;j++){
                    if(j>0){
                        System.out.print(",");
                    }
                }
                System.out.println(");");
            }
        }
    }

    public static void printField(Class cls){
        Field[] fields = cls.getDeclaredFields();
        for(Field f:fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.println(type.getName()+" "+name+";");
        }
    }

}
