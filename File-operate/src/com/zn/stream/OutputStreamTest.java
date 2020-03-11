package com.zn.stream;

import java.io.*;

/**
 * @ClassName OutputStreamTest
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 19:54
 */


public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:"+File.separator+"JavaProject"+File.separator+"java-io"+File.separator
                +"demo-io.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();//创建多级父目录
        }

        //OutputStream是一个抽象类，所以需要通过子类进行实例化
        OutputStream outputStream = new FileOutputStream(file);
        //要求输出到位文件的内容
        String msg  = "这是一个新建的文本文档！";
        //将内容变为字节数组
        outputStream.write(msg.getBytes());
        //关闭输出
        outputStream.close();
    }
}
