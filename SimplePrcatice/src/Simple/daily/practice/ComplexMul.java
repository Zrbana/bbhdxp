package Simple.daily.practice;

/**
 * 题目描述：
 * 给定两个表示复数的字符串。
 *
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * 两个复数的乘法可以依下述方法完成：
 *
 *
 * 我们简单地根据 '+' 和 'i' 符号分割给定的复杂字符串的实部和虚部。
 * 我们把 aa 和 bb 两个字符串的实部分别存储为 x[0]x[0] 和 y[0]y[0]，虚部分别用 x[1]x[1] 和 y[1]y[1] 存储。
 *
 * 然后，将提取的部分转换为整数后，根据需要将实部和虚部相乘。然后，我们再次以所需的格式形成返回字符串，并返回结果。
 *
 */
public class ComplexMul {

    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }
}
