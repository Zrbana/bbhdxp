package com.zn.file;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 19:25
 */


public class FileTest {
    //File类的使用:文件操作


    public static void main(String[] args) throws IOException {
        //定义要操作的文件路径
        //此处存在问题：不同操作系统下分隔符不同
        //使用File类的一个常量separator
        File file = new File("E:"+File.separator+"JavaProject"+File.separator+"java-io"+File.separator
                +"demo-io.txt");
        //File file  = new File("E:\\JavaProject\\java-io\\demo-io.txt");
        //在相应目录下生成demo-io.txt文件
        file.createNewFile();
        //判断文件是否存在
        System.out.println(file.exists());
    }
}
