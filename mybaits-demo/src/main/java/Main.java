import com.sun.media.sound.ReferenceCountingDevice;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yuisama
 * @Date 2020/5/14 14:07
 */


public class Main {

    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];
    public static void main(String[] args){
        Main objA = new Main();
        Main objB = new Main();
        objA.instance = objB;
        objB.instance = objA;

        objA=null;
        objB=null;
        System.gc();
    }
}
