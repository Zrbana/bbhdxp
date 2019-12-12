package www.javase;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {

    //没有属性
    static class OOMObject {

    }

    //JVM 程序启动的时候通过JVM参数指定最大最小内容
    //-Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            //循环一次，在JVM堆上创建一个对象
            list.add(new OOMObject());
        }
    }
}

