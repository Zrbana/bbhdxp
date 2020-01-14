package calculator.stack.fun;

import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		String expression = "173*24*2-55+12-517+36-41"; // = 7739
		//String expression = "7*2*2-5+1-5+3-4"; // = 18
		Stack<Integer> numStack = new Stack<Integer>(); //数栈
		Stack<Character> opStack = new Stack<Character>(); //符号栈
		char ch = ' '; //用来存放遍历到的元素
		String keepNum = ""; //用来处理多位数
		
		for (int i = 0; i < expression.length(); i++) {
			ch = expression.charAt(i);
			if (isOper(ch)) {
				if (!opStack.isEmpty()) {
					if (priority(ch, opStack.peek()) <= 0) {
						numStack.push(cal(numStack.pop(), numStack.pop(), opStack.pop()));
					}
				}
				opStack.push(ch);
			} else {
				keepNum += ch;
				if (i == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					if (isOper(expression.charAt(i + 1))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}
			}
		}
		numStack.push(cal(numStack.pop(), numStack.pop(), opStack.pop()));
		System.out.println(expression + " = " + numStack.pop());
	}

	// 判断字符是否为运算符
	public static boolean isOper(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	// 判断两个运算符的优先级
	public static int priority(char ch1, char ch2) {
		if ((ch1 == '+' || ch1 == '-') && (ch2 == '*' || ch2 == '/'))
			return -1;
		if ((ch1 == '*' || ch1 == '/') && (ch2 == '+' || ch2 == '-'))
			return 1;
		return 0;
	}

	// 运算方法
	public static int cal(int a, int b, int op) {
		int res = 0;
		switch (op) {
		case '+':
			res = a + b;
			break;
		case '-':
			res = b - a;
			break;
		case '*':
			res = a * b;
			break;
		case '/':
			res = b / a;
			break;
		default:
			break;
		}
		return res;
	}

}
