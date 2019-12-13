package www.cases;

import www.annotation.Case;
import www.annotation.Measurement;

@Measurement(iterations = 100,group = 10)
public class algorithmCase implements Case {
    public void FibRecursionTest(){
        fib_recursion(30);
    }
    public void FibDongGuiTest(){
        fib_donggui(1000);
    }

    //递归求解
    public int fib_recursion(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return fib_recursion(n-2)+fib_recursion(n-1);
    }


    //动态规划求解
    public int fib_donggui(int n){
        if(n<0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int q=1;
        int h = 1;
        int res = 0;
        while (n>2){
            res = q+h;
            q=h;
            h=res;
            n--;
        }
        return res;
    }
}









