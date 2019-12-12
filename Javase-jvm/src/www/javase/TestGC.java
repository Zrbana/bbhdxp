package www.javase;

public class TestGC {

    public static void code1() {
        Test test1 = new Test();
        //2m byte[], instance->null
        Test test2 = new Test();
        //2m byte[],instance->null
        test1.instance = test2;// -> 堆上的对象
        test2.instance = test1;// -> 堆上的对象
        test1 = null; //test1不再引用堆上的对象
        test2 = null;//test2不再引用堆上的对象
        //堆上的对象  等待 垃圾回收器回收

        System.gc();
    }

    public static void main(String[] args) {
        //Part1
        Test2.test2 = new Test2(); //this
        Test2.test2 = null;
        System.gc();//调用垃圾回收方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Test2.test2 == null) {
            System.out.println("对象已死");
        } else {
            Test2.test2.isAlive();
        }

        //Part2
        Test2.test2 = null;
        System.gc();//调用垃圾回收方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Test2.test2 == null) {
            System.out.println("对象已死");
        } else {
            Test2.test2.isAlive();
        }

        while (true){

        }

    }

}

class Test {

    private byte[] bigSize = new byte[1024 * 1024 * 8];

    public Object instance = null;

}


class Test2 {

    public static Test2 test2;

    public void isAlive() {
        System.out.println("对象还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行对象的finalize");
        test2 = this;//this当前对象
    }
}
