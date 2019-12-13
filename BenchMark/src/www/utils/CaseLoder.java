package www.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CaseLoder {
    /**
     * 返回一个LIst集合，集合中包含了所有测试类的名字，
     * 即以case为结尾的类名
     * 目的是得到这些名字，就能得到这些待测类的Class类，进一步得到
     * 他们的实例化对象
     */
    public List<String> load() throws IOException {
        List<String > classNameList = new ArrayList<>();
        //定义存放测试类的包的路径
        String pkg = "www.annotaion.cases";
        ClassLoader classLoader = this.getClass().getClassLoader();

        //返回的是一个迭代器，存放着对应的URL
        Enumeration<URL> urls = classLoader.getResources(pkg);
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            //getProtocol()函数作用是返回 该URL的协议名称，例如file
            if(!url.getProtocol().equals("file")){
                continue;
            }
            //获取该URL的路径，并用decode函数进行转码，不转吗的话就会出现乱码
            String dirname = URLDecoder.decode(url.getPath(),"UTF-8");
            File dir = new File(dirname);
            //如果不是目录文件
            if(!dir.isDirectory()){
                continue;
            }
            File[] files = dir.listFiles();//获取这个目录下的所有文件
            //若为空，则跳过
            if(files==null)
                continue;
            for(File file:files){
                String fileName = file.getName();
                /**
                 * 这里的split分割函数里用.分割时，务必加上转移字符
                 * 因为这里的参数是一个正则表达式，而在正则表达式里表示全字符匹配
                 */
                String[] str = fileName.split("\\.");
                //判断这个文件是不是class文件，如果不是，直接跳过
                //判断方法，用.分割类名后，获取最后欧一个元素，即后缀名，即可判断
                if(!str[str.length-1].equals("class"))
                    continue;

                //获取该class文件的名称（即除去.class的部分）
                String className = fileName.substring(0,fileName.length()-6);            }
                classNameList.add(className);

        }
        return classNameList;
    }

}








