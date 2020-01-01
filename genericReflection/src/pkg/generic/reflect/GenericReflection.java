package pkg.generic.reflect;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflection {
    public static void main(String[] args) {
        String name;
        if(args.length>0){
            name = args[0];
        }else{
                Scanner in = new Scanner(System.in);
                name = in.next();

        }
        try {
            {
                Class<?> cls = Class.forName(name);
                printClass(cls);
                for(Method m:cls.getDeclaredMethods()){
                    printMethod(m);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cls){
        System.out.print(cls);
        printTypes(cls.getTypeParameters(),"<",",",">",true);
        Type sc = cls.getGenericSuperclass();
        if(sc!=null){
            System.out.print("extends");
            printType(sc,false);
        }
        printTypes(cls.getGenericInterfaces(),"implements",",","",false);
        System.out.println();

    }
    public static void printMethod(Method m){
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print("");
        printTypes(m.getTypeParameters(),"<",",",">",true);

        printType(m.getGenericReturnType(),false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getTypeParameters(),"<",",",">",false);
        System.out.println(")");
    }
    public static void printTypes(Type[] types,String pre,String sep,String suf,boolean isDefination){
        if(pre.equals("extends") && Arrays.equals(types,new Type[]{Object.class})){
            return ;
        }
        if(types.length>0){
            System.out.print(pre);
        }
        for(int i= 0;i<types.length;i++){
            if(i>0){
                System.out.print(sep);
                printType(types[i],isDefination);
            }
        }
        if(types.length>0){
            System.out.print(suf);
        }
    }
    public static void printType(Type type,boolean isDefination){
        if(type instanceof Class){
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        else if(type instanceof TypeVariable){
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if(isDefination){
                printTypes(t.getBounds(),"extends","&","",false);
            }
        }
        else if(type instanceof WildcardType){
            WildcardType t= (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(),"extends","&","",false);
            printTypes(t.getLowerBounds(),"super","&","",false);
        }
        else if(type instanceof ParameterizedType){
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if(owner!=null){
                printType(owner,false);
                System.out.print(".");
            }
            printType(t.getRawType(),false);
            printTypes(t.getActualTypeArguments(),"<",",",">",false);
        }
        else if(type instanceof GenericArrayType){
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(),isDefination);
            System.out.print("[]");
        }
    }

}
