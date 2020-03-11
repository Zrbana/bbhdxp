package com.zn.project;

/**
 * @ClassName CopyFile
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/11 20:15
 */

import com.zn.file.FileTest;

import java.io.*;

/**
 * 建立一个CopyFile程序类，这个类通过初始化参数接收源文件与目标文
 * 件路径。实现文件拷贝
 *
 * 1. 要想实现数据的拷贝肯定是要通过流的方式来完成，对于流有两类，由于要拷贝的内容不一定是文字数
 * 据，所以次此处我们采用字节流。
 * 2. 在进行拷贝的时候需要确定模式：a.在程序中开辟一个数组，该数组长度为文件长度，将所有数据一次
 * 性读取到该数组中随后进行输出保存。b.采用同边读边写的方式完成。
 */

public class CopyFile {
}


/**
 * 建立一个专门负责拷贝文件处理的类
 * 1.判断拷贝的源文件是否存在
 * 2.判断目标文件的父路径是否存在，不存在则创建
 * 3.进行文件拷贝的处理
 */
class CopyUtil{

    private CopyUtil(){}

    /**
     * 判断源路径是否存在
     * @param path
     * @return
     */
    public static boolean fileIsExists(String path){
        return new File(path).exists();
    }

    /**
     * 判断父路径是否存在，不存在则创建
     * @param path
     */
    public static void createParentsDir(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) { // 路径不存在
            file.getParentFile().mkdirs(); // 创建多级父目录
        }
    }

    /**
     * 文件拷贝
     * @param sourcePath
     * @param destPath
     * @return
     */
    public static boolean copyFile(String sourcePath, String destPath) {
        File inFile = new File(sourcePath) ;
        File outFile = new File(destPath) ;
        FileInputStream fileInputStream = null ;
        FileOutputStream fileOutputStream = null ;
        try {
            fileInputStream = new FileInputStream(inFile) ;
            fileOutputStream = new FileOutputStream(outFile) ;
            copyFileHandle(fileInputStream, fileOutputStream) ; // 完成具体文件拷贝处理
        } catch (IOException e) {
            e.printStackTrace() ;
            return false ;
        }finally {
            try {
                fileInputStream.close() ;
                fileOutputStream.close() ;
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 具体的文件拷贝操作
     * @param inputStream
     * @param outputStream
     * @throws IOException
     */
    private static void copyFileHandle(InputStream inputStream, OutputStream
            outputStream) throws IOException {
        long start = System.currentTimeMillis() ;
// InputStream有读取单个字节的方法
// OutputStream有输出单个字节的方法
        int temp = 0 ;
        do {
            temp = inputStream.read() ; // 读取单个字节数据
            outputStream.write(temp) ; // 通过输出流输出
        } while (temp != -1); // 如果有数据继续读取
        long end = System.currentTimeMillis() ;
        System.out.println("拷贝文件所花费的时间："+(end-start)) ;
    }
}











