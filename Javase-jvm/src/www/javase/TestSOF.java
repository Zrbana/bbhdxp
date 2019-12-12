package www.javase;
public class TestSOF {

    private int stackDeep = 0;

    //-Xss108k(至少)
    public void setDeep() {
        stackDeep++;
        setDeep();
    }

    public static void main(String[] args) {
        TestSOF testSOF = new TestSOF();
        try {
            testSOF.setDeep();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("Call deep " + testSOF.stackDeep);
        }
    }


}

