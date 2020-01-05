package test.frame.cases;

import test.frame.annotation.Case;
import test.frame.annotation.MeasureMent;

@MeasureMent(iterations = 100,group = 5)
public class StringContactCase implements Case {

    //@Benchmark
    //@Measurement(iterations = 100,group = 8)
    //@WarmUp(iterations = 5)
    public  void contactAdd() {
        String s = "";
        for(int i=0; i<10000; i++) {
            s += "a";
        }
    }

    //@Benchmark
    //@Measurement(iterations = 100,group = 8)
    //@WarmUp(iterations = 5)
    public void contactStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<10000; i++) {
            stringBuilder.append("a");
        }
    }

}

