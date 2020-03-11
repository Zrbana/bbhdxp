package com.zn.stream;

import java.io.*;

/**
 * @ClassName InputStreamTest
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 20:08
 */


public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        //定义文件路径
        File file = new File("E:"+File.separator+"JavaProject"+File.separator+"java-io"+File.separator
                +"demo-io.txt");
        if(file.exists()){
            InputStream in = new FileInputStream(file);
            byte[] data = new byte[1024];//每次可以读取的最大数量
            int len = in.read(data);
            String str = new String(data,0,len);
            System.out.println("读取内容【"+str+"】");
            in.close();
        }
    }
}
