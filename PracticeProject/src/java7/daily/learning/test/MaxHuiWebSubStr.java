package java7.daily.learning.test;

/**
 * @ClassName MaxHuiWebSubStr
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/24 23:30
 */

//最长回文子串
public class MaxHuiWebSubStr {
    //暴力法法
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        String res=s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String k=s.substring(i,j);
                String rk=new StringBuffer(k).reverse().toString();
                if(k.equals(rk)&&k.length()>res.length()){
                    res=k;
                }
            }

        }
        return res;
    }

    //动态规划
    public int dp(int n) {
        n++;
        int min[] = new int[n];
        int[] V = {1, 3, 5};
        min[0]=0;
        for (int i = 1; i < n; i++) {
            min[i] =  min[i-1]+1;
            for (int j = 0; j < V.length; j++) {
                if (V[j] > i) {
                    break;
                }
                if (min[i - V[j]] < min[i-1]) {
                    min[i] = min[i - V[j]] + 1;
                }
            }
        }
        return min[n - 1];
    }
}
