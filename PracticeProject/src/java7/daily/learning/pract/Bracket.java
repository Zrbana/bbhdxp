package java7.daily.learning.pract;

/**
 * @ClassName Bracket
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/16 21:27
 */

import java.util.Stack;

/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 *
 *
 * 方法：.碰到")"开始弹出栈顶的"("，如果此时栈为空，则返回false 2.碰到其他内容直接返回false 3.字符串结尾时，
 * 栈非空返回false
 */
public class Bracket {
   public boolean checkBracket(String str,int n){
       Stack<Character> lefts = new Stack<>();
       if(str.length()==0 || str.length()!=n){
           return false;
       }
       for(int i = 0; i < n; i++){
           if(str.charAt(i) == '('){
               lefts.push(str.charAt(i));
           }else if(str.charAt(i) == ')'){
               if(lefts.empty()){
                   return false;
               }else{
                   lefts.pop();
               }
           }else{
               return false;
           }
       }
       if(!lefts.empty()){
           return false;
       }else{
           return true;
       }
   }
}
