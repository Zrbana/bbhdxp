import java.io.*;

/**
 * @ClassName Person
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/21 21:28
 */

//Person类可以被序列化
//此时Person类产生的每一个对象都可以实现二进制的数据传输
class Person implements Serializable {
    private transient String name;//这个属性不需要序列化

    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "姓名:"+this.name+"、年龄"+this.age;
    }
}

public class JavaAPIDemo{

    private static final File SAVE_FILE = new File("\"D:\" + File.separator + \"mldn.person\"");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(loadObject());
    }

    public static void saveObject(Object obj) throws Exception{
        ObjectOutputStream oos  =new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);//序列化
        oos.close();
    }
    public static Object loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();//反序列化
        ois.close();
        return obj;
    }
}
