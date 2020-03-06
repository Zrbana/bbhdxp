package java7.daily.learning;

/**
 * @ClassName Test_04
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/6 21:41
 */


public class Test_04 {
}
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
// 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
//
class Solution1{
    //暴力法
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
    //调用String内部方法
    public String replaceSpaces2(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }

}