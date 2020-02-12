package www.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述：
 * 无重复字符的最长子串
 * 返回其长度
 */
public class Test{
    /**
     * 方法一：暴力法，逐个检查所有的子字符串，看是否是无重复字符的子串
     */


    /**
     * 枚举给定字符串的所有子字符串：
     * 开始索引：i   结束索引:j
     *i:0--n-1  和  j:i+1---n
     */
    public int getLength(String s){
        int n = s.length();
        int res = 0;
        for(int i = 0;i<=n-1;i++){
            for(int j=i+1;j<=n;j++){

                //元素唯一
                if(isUnique(s,i,j)){
                    res = Math.max(res,j-i);
                }
            }
        }
        return res;
    }

    /**
     * 判断子字符串中的每个字符是否唯一
     * 如果唯一 return true
     * 不唯一 return false
     * @param subString
     * @return
     */
    public boolean isUnique(String subString,int start,int end){

        //Set集合元素不可重复
        Set<Character> set = new HashSet<>();
        for(int i=start;i<end;i++){
            Character ch = subString.charAt(i);
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }
        return true;

    }


    /**
     * 方法二：我们使用 HashSet 将字符存储在当前窗口 [i,j)[i, j)[i,j)
     * （最初 j=ij = ij=i）中。 然后我们向右侧滑动索引 jjj，
     * 如果它不在 HashSet 中，我们会继续滑动 jjj。
     * 直到 s[j] 已经存在于 HashSet 中。此时，
     * 我们找到的没有重复字符的最长子字符串将会以索引 iii 开头。
     * 如果我们对所有的 iii 这样做，就可以得到答案。
     */
    public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }


/**
 * 使用HashMap
 */
    public int lengthOfLongestSub(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * 方法四：用一个整数数组
     * int[26] a-z和A-Z
     * int[128] ASCII 码
     * int[256] 扩展ASCII
     */

 public int longestLength(String s){
     int n=s.length();
     int ans=0;
     int[] index  = new int[128];
     for(int j =0,i=0;j<n;j++){
         i=Math.max(index[s.charAt(j)],i);
         ans=Math.max(ans,j-i+1);
         index[s.charAt(j)] = j+1;
     }
     return ans;
 }







}














