package com.zn.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName WriterTest
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 20:12
 */


public class WriterTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:"+File.separator+"JavaProject"+File.separator+"java-io"+File.separator
                +"demo-io.txt");
        if (!file.getParentFile().exists()) { // 必须保证父目录存在
            file.getParentFile().mkdirs() ; // 创建多级父目录
        }
        String msg = "这是一个新操作" ;
        Writer out = new FileWriter(file) ;
        out.write(msg) ;
        out.close() ;
    }
}
