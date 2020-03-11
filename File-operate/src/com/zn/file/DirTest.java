package com.zn.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName DirTest
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 19:34
 */


public class DirTest {
    //File类的使用：目录操作
    public static void main(String[] args) throws IOException {
        File file = new File("E:"+File.separator+"JavaProject"+File.separator+"java-io"+File.separator
                +"test.java");
        if(!file.getParentFile().exists()){//创建父目录
            file.getParentFile().mkdirs();//有多少级目录就创建多少级

        }
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }

        if(file.exists() && file.isFile()){
            System.out.println("文件大小"+file.length());
            System.out.println("最后一次修改日期"+new Date(file.lastModified()));
        }

        //列出目录中的全部内容
        File newfile = new File("E:"+File.separator+"JavaProject");
        if(newfile.exists() && newfile.isDirectory()){
            //列出目录中的全部内容
            //此方法只能列出本目录中的第一级信息
            //如果要列出所有的信息，就要递归完成
            File[] files = newfile.listFiles();
            for(File file1:files){
                System.out.println(file1);
            }
        }
        listAllFiles(newfile);
    }

    /**
     * 列出指定目录下全部的子目录信息
     * @param file
     */
    public static void listAllFiles(File file){
        if(file.isDirectory()){
            File[] result = file.listFiles();
            if(result!=null){
                for(File file1:result){
                    listAllFiles(file1);
                }
            }else{
                System.out.println(file);
            }
        }
    }
}
