package test.frame.cases;

import test.frame.annotation.BenchMark;
import test.frame.annotation.Case;
import test.frame.annotation.MeasureMent;

@MeasureMent(iterations = 100,group = 10)
public class algorithmCase implements Case {
    @BenchMark
    public void FibRecursionTest() {
        fib_recursion(25);
    }
    // @Benchmark
    public void FibDongGuiTest() {
        fib_donggui(1000);
    }
    //递归求解斐波那契
    public int fib_recursion(int n) {
        if(n<=0) {
            return 0;
        }
        if(n == 1 || n== 2) {
            return 1;
        }
        return fib_recursion(n-2) + fib_recursion(n-1);
    }

    //动态规划求解斐波那契
    public int fib_donggui(int n) {
        if(n < 0) {
            return 0;
        }
        if (n==1 || n==2) {
            return 1;
        }
        int q = 1;
        int h = 1;
        int res = 0;
        while(n > 2) {
            res = q+h;
            q = h;
            h = res;
            n--;
        }
        return res;
    }
}
