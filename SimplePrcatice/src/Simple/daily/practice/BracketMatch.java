package Simple.daily.practice;

import java.util.HashMap;
import java.util.Stack;

/**
 * 括号匹配
 * 方法：
 * 1. 将左右括号的匹配关系存入HashMap中，
 * 2. 初始化一个栈，如果是左括号，在hashMap中用key检查是否有value与之对应，没有就入栈
 *    若是右括号，则出栈
 *  3. 如果最后栈为空，则全部匹配成功 return true
 */
public class BracketMatch {

    //存入括号的键值映射关系
   private HashMap<Character,Character> mappings;

   public BracketMatch(){
       this.mappings = new HashMap<Character, Character>();
       this.mappings.put(')', '(');
       this.mappings.put('}', '{');
       this.mappings.put(']', '[');

   }
    public static void main(String[] args) {
       BracketMatch bracket  = new BracketMatch();
        System.out.println(bracket.isVaild("()[]{[()]}"));
        System.out.println( bracket.isVaild("()[]{[()]"));
        System.out.println(bracket.isVaild("()[]{[())]}"));
    }
    public boolean isVaild(String s) {


        //将字符串存入Stack中
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果当前hashMap中包含这个字符，则取栈顶看是否匹配
            if (this.mappings.containsKey(c)) {
                char elemTop = stack.empty()?'#':stack.pop();
                if(elemTop!=this.mappings.get(c)){
                    return false;
                }
            }else{
                //不包含这个字符，则将其入栈
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }


}
