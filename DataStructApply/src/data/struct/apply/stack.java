package data.struct.apply;

import java.util.Stack;

//比较含有退格的字符串
public class stack {
    Stack<Character> s = new Stack<Character>();
    Stack<Character> t = new Stack<Character>();
    public boolean backspaceCompare(String S, String T) {
        for (Character c : S.toCharArray()) {
            //遇到退格键，将前一个字符出栈
            if (c == '#' && !(s.isEmpty())){
                s.pop();
            }else if(c != '#' && (S.isEmpty())){
                s.push(c);
            }
        }
        for (Character c : T.toCharArray()) {
            //遇到退格键，将前一个字符出栈
            if (c == '#' && !(t.isEmpty())){
                t.pop();
            }else if(c != '#' && (t.isEmpty())){
                t.push(c);
            }
        }
        if(s.size()!=t.size()){
            return false;
        }
        while(s.size()!=0)
            if (!s.isEmpty() && !t.isEmpty() && s.pop() != t.pop())
                return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "abc#d";
        String t = "ab#cd";
        String a = "av##";
        String b = "e#m#";
        stack str = new stack();
        System.out.println(str.backspaceCompare(s,t));
        System.out.println(str.backspaceCompare(a,b));
    }

}
