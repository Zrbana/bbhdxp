

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {
    /**
     * 计算器
     */
    private JFrame frame = new JFrame();

    //计算器上各按键的名字(从上到下，从左到右)
    private String[] keys = {"%","CE","C","Back","1⁄x","X²","√x","÷","7","8","9","X","4","5","6","-","1","2","3","+","+/-","0",".","="};
    private JButton buttons[] = new JButton[keys.length];  //计算器上按键的按钮
    private JTextField resultText = new JTextField("0");  //显示计算结果文本框

    private boolean firstDigit = true;  // 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字
    private double resultNum = 0.0000;   // 计算的中间结果
    private String operator = "=";   // 当前运算的运算符（按键"C"时需要将其还原为"="）
    private boolean operateValidFlag = true;   // 判断操作是否合法

    /**
     * 构造函数
     */
    public Calculator() {
        init();  // 初始化计算器
        frame.setTitle("计算器 -- @author 程铧庆");
        frame.setSize(366, 439);
        frame.setLocation(500, 300);
        frame.setResizable(true);  // 允许修改计算器窗口的大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 初始化计算器
     */
    private void init() {

        Color color1 = new Color(181, 181, 181);  //功能键和运算符颜色
        Color color2 = new Color(126, 192, 238);  //等于号专属颜色
        Color color3 = new Color(232, 232, 232);  //背景颜色
        // 建立一个画板放文本框
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(resultText);
        resultText.setFont(new Font("楷体",Font.BOLD,43));  //设置文本框中文字的字体以及大小，加粗
        resultText.setHorizontalAlignment(JTextField.RIGHT);  //文本框中的内容采用右对齐方式
        resultText.setEditable(false);  //不能修改结果文本框
        resultText.setBorder(null);  //删除文本框的边框
        // 设置文本框背景颜色
        resultText.setBackground(color1);

        // 初始化计算器上键的按钮，将键放在一个画板内
        JPanel keysPanel = new JPanel();
        // 用网格布局器，6行，4列的网格，网格之间的水平方向垂直方向间隔均为2个像素
        keysPanel.setLayout(new GridLayout(6, 4, 2, 2));
        //初始化功能按钮
        for(int i = 0; i < 8; i++) {
            buttons[i] = new JButton(keys[i]);
            keysPanel.add(buttons[i]);
            buttons[i].setBackground(color3);
            buttons[i].setForeground(Color.black);
            buttons[i].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            buttons[i].setBorderPainted(false);  //去除按钮的边框
        }
        //初始化运算符及数字键按钮
        for(int i = 8; i < keys.length; i++) {
            buttons[i] = new JButton(keys[i]);
            keysPanel.add(buttons[i]);
            if((i+1)%4==0) buttons[i].setBackground(color3);
            else buttons[i].setBackground(Color.white);
            buttons[i].setForeground(Color.black);
            buttons[i].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            buttons[i].setBorderPainted(false);  //去除按钮的边框
        }
        buttons[23].setBackground(color2);  // '='符键用特殊颜色
        keysPanel.setBackground(color1);

        //将文本框所在的面板放在北部，将keysPanel面板放在计算器的中部
        frame.getContentPane().add("North", textPanel);
        frame.getContentPane().add("Center", keysPanel);
        //设置两个面板的边框，尽量还原win10计算器
        textPanel.setBorder(BorderFactory.createMatteBorder(25,3,1,3,color1));
        keysPanel.setBorder(BorderFactory.createMatteBorder(6,3,3,3,color1));

        // 为各按钮添加事件监听器，都使用同一个事件监听器。
        for (int i = 0; i < keys.length; i++) {
            buttons[i].addActionListener(this);
        }
    }

    /**
     * 处理事件
     */
    public void actionPerformed(ActionEvent ev) {

        String command = ev.getActionCommand();  // 获取事件源
        if (command.equals(keys[3])) {
            // 用户按了"Back"键
            doBackspace();
        } else if (command.equals(keys[1])) {
            // 用户按了"CE"键
            resultText.setText("0");
        } else if (command.equals(keys[2])) {
            // 用户按了"C"键
            doC();
        } else if ("0123456789.".indexOf(command) >= 0) {
            // 用户按了数字键或者小数点键
            doNumber(command);
        } else if(command.equals(keys[0]) || command.equals(keys[4]) || command.equals(keys[5]) ||
                command.equals(keys[6]) || command.equals(keys[20])) {
            // 用户按了只需一个数的运算键（求倒数，%，开方，平方，取正负数）
            doOperator1(command);
        } else {
            doOperator2(command);
        }
    }

    /**
     * 处理Back键被按下的事件
     */
    private void doBackspace() {
        String text = resultText.getText();
        int i = text.length();
        if (i > 0) {
            text = text.substring(0, i - 1);  // 退格，将文本最后一个字符去掉
            if (text.length() == 0) {
                // 如果文本没有内容了，则初始化计算器的各种值
                resultText.setText("0");
                firstDigit = true;
                operator = "=";
            } else {
                // 显示新的文本
                resultText.setText(text);
            }
        }
    }

    /**
     * 处理C键被按下的事件
     */
    private void doC() {
        // 初始化计算器的各种值
        resultText.setText("0");
        firstDigit = true;
        operator = "=";
    }

    /**
     * 处理数字键被按下的事件
     */
    private void doNumber(String key) {
        if (firstDigit) {
            // 输入的为第一个数
            resultText.setText(key);
        } else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
            // 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
            resultText.setText(resultText.getText() + ".");
        } else if (!key.equals(".")) {
            // 如果输入的不是小数点，则将数字附在结果文本框的后面
            resultText.setText(resultText.getText() + key);
        }
        firstDigit = false;
    }

    /**
     * 处理运算符键被按下的事件
     */
    //只需一个数的运算
    private void doOperator1(String key) {
        operator = key;  // 运算符为用户按的按钮
        if (operator.equals("1⁄x")) {
            // 倒数运算
            if (resultNum == 0) {
                operateValidFlag = false;  //操作不合法
                resultText.setText("零没有倒数");
            } else {
                resultNum = 1 / getNumberFromText();
            }
        } else if (operator.equals("√x")) {
            // 平方根运算
            if (resultNum < 0) {
                operateValidFlag = false;  //操作不合法
                resultText.setText("根号内不能为负");
            } else {
                resultNum = Math.sqrt(getNumberFromText());
            }
        } else if (operator.equals("X²")) {
            // 平方运算
            resultNum = getNumberFromText()*getNumberFromText();
        } else if (operator.equals("%")) {
            // 百分号运算，除以100
            resultNum = getNumberFromText() / 100;
        } else if (operator.equals("+/-")) {
            // 正数负数运算
            resultNum = getNumberFromText() * (-1);
            if (operateValidFlag) {
                // 操作合法的情况下，结果为小数保留小数点后4位，整数正常输出
                long t1;
                double t2;
                t1 = (long) resultNum;
                t2 = resultNum - t1;
                if (t2 == 0) {
                    resultText.setText(String.valueOf(t1));
                } else {
                    resultText.setText(String.valueOf(new DecimalFormat("0.0000").format(resultNum)));
                }
            }
            firstDigit = true;
            operateValidFlag = true;
        }
    }

    //需要两个数的运算
    private void doOperator2(String key) {
        if (operator.equals("÷")) {
            // 除法运算
            // 如果当前结果文本框中的值等于0
            if (getNumberFromText() == 0.0) {
                operateValidFlag = false;  //操作不合法
                resultText.setText("除数不能为零");
            } else {
                resultNum /= getNumberFromText();
            }
        } else if (operator.equals("+")) {
            // 加法运算
            resultNum += getNumberFromText();
        } else if (operator.equals("-")) {
            // 减法运算
            resultNum -= getNumberFromText();
        } else if (operator.equals("X")) {
            // 乘法运算
            resultNum *= getNumberFromText();
        } else if (operator.equals("=")) {
            // 赋值运算
            resultNum = getNumberFromText();
        }
        if (operateValidFlag) {
            // 操作合法的情况下，结果为小数保留小数点后4位，整数正常输出
            long t1;
            double t2;
            t1 = (long) resultNum;
            t2 = resultNum - t1;
            if (t2 == 0) {
                resultText.setText(String.valueOf(t1));
            } else {
                resultText.setText(String.valueOf(new DecimalFormat("0.0000").format(resultNum)));
            }
        }
        operator = key;  // 运算符为用户按的按钮
        firstDigit = true;
        operateValidFlag = true;
    }

    /**
     * 从结果文本框中获取数字
     */
    private double getNumberFromText() {
        double result = 0;
        try {
            result = Double.valueOf(resultText.getText()).doubleValue();
        } catch (NumberFormatException e) {
        }
        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }

}


