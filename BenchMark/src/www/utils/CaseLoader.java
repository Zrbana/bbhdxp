package www.utils;

import www.annotation.Benchmark;
import www.annotation.Case;
import www.annotation.Measurement;
import www.annotation.WarmUp;

import javax.xml.soap.SAAJResult;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner {

    //初始化
    public static List<Case> InitCase() throws Exception{
        CaseRunner caseRunner = new CaseRunner();
        List<Case> list = caseRunner.buildCase(new CaseLoader());
        return list;
    }


    //返回List集合，集合中存放的是当前cases包下所有以Case结尾的类的实例化对象
    public List<Case> buildCase(CaseLoader caseLoader) throws Exception{
        List<String> classNameList = new ArrayList<>();
        List<Case> caseList = new ArrayList<>();
        classNameList = caseLoader.load();
        for(String name: classNameList) {
            Class bCaseClass = Class.forName("www.yy.main.cases."+name);
            //获取测试类（即**Case类）的实例化对象
            Case bCase = (Case)bCaseClass.newInstance();
            caseList.add(bCase);
        }
        return caseList;
    }

    public void runCase(Case bCase) throws Exception{
        int iterations = 100;    //每一组测试数的默认初始值
        int group = 10;     //组数的默认初始值
        int iterationsWarmUp = 2;   //预热默认值

        //获取该类的Class对象；
        Class<?> cla = bCase.getClass();
        //获取类的注解信息,即第一层信息，如果没有再使用第二层
        Annotation measurementW = cla.getAnnotation(Measurement.class);
        if(measurementW != null) {
            Measurement measurement = (Measurement)measurementW;
            iterations = measurement.iterations();
            group = measurement.group();
        }
        Method[] methods = cla.getMethods();
        for(Method method : methods) {
            //获取该类的方法的注解信息，即第二层信息
            Annotation benchmark = method.getAnnotation(Benchmark.class);
            //扫描该类的所有方法，如果有Benchmark注解的就是用来测试的方法
            if(benchmark == null) {
                continue;
            }
            Measurement measurement = method.getAnnotation(Measurement.class);
            //如果测试方法中就有设置好的注解参数，我们将他读取出来
            if(measurement != null) {
                iterations = (measurement).iterations();
                group = (measurement).group();
            }
            //预热部分,如果没有预热注解，则不会进行预热；
            WarmUp warmUp = method.getAnnotation(WarmUp.class);
            if(warmUp != null) {
                iterationsWarmUp = (warmUp).iterations();
            }else {
                iterationsWarmUp = 0;
            }
            //再调用具体实现的方法
            run(bCase, method, iterations, group, iterationsWarmUp);
        }
    }

    //真正来实现检测时间的方法
    public void run(Case bCase, Method method, int iterations, int group, int iterationsWarmUp) throws Exception{
        String caseName = bCase.getClass().getName();
        String methodName = method.getName();
        System.out.println("这是针对 "+ caseName+"的"+methodName+"方法"+" 的检测报告：");
        //预热检测部分
        if(iterationsWarmUp != 0) {
            System.out.println("-----------------------------------------------------");
            System.out.println("预热开始..........");
            for(int k=0; k<iterationsWarmUp; k++) {
                System.out.print("第 "+(k+1)+" 次预热：");
                long timeStart = System.nanoTime();
                //每个预热单位默认执行10次，为了更加简洁，这个参数是死的
                for(int i=0; i<10;i++) {
                    method.invoke(bCase);
                }
                long timeEnd = System.nanoTime();
                long time = timeEnd - timeStart;
                System.out.println("耗时："+time/10+" ns");
            }
            System.out.println("预热完毕..........");
            System.out.println("-----------------------------------------------------");
        }
        int totleTime = 0;
        for (int i=0; i<group; i++) {
            System.out.print("这是第 "+(i+1)+" 次检测 | ");
            long timeStart = System.nanoTime();
            for(int j=0; j<iterations; j++) {
                method.invoke(bCase);
            }
            long timeEnd = System.nanoTime();
            long time = timeEnd - timeStart;
            totleTime += time/iterations;
            System.out.println("耗时："+time/iterations+" ns");
        }
        System.out.println("平均耗时："+totleTime/group+ " ns"+"，折合："+totleTime/group/1000000+"ms");
        System.out.println("#############################################################");
    }
}
public class CaseLoader {


    //返回一个List集合，集合中包含了所有测试类的名字，
    // 即类名称以Case为结尾的类名称，
    // 目的是得到这些名字，就能
    //得到这些待测类的Class类，进一步就可以得到它们的实例化对象


    public List<String> load() throws Exception {
        List<String> classNameList = new ArrayList<>();
        //定义你放测试文件的那个包的路径
        String pkg = "www/yy/main/cases/";
        ClassLoader classLoader = this.getClass().getClassLoader();
        //返回的是一个迭代器，存放着对应的URL
        Enumeration<URL> urls = classLoader.getResources(pkg);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            //getProtocol()函数作用是返回该URL的协议名称，例如file
            if (!url.getProtocol().equals("file")) {
                continue;
            }
            //获取该URL的路径，并用decode函数进行转码，不转码的话会出现乱码
            String dirname = URLDecoder.decode(url.getPath(), "UTF-8");
            File dir = new File(dirname);
            if (!dir.isDirectory()) {      //如果不是目录文件
                continue;
            }
            File[] files = dir.listFiles();    //获取这个目录下的所有文件
            //若为空，则跳过
            if (files == null) continue;
            for (File file : files) {
                String fileName = file.getName();

                //这里的split分割函数里用.分割时，务必加上转义字符，因为这里的参数是一个正则表达式，而.在正则表达式
                //里表示全字符匹配的意思
                String[] str = fileName.split("\\.");
                //判断这个文件是不是class文件，如果不是，直接跳过
                //判断方法：用.分割类名后，获取最后一个元素，即后缀名，即可判断
                if (!(str[str.length - 1].equals("class"))) {
                    continue;
                }
                //获取该class文件的名称（即除去.class的那一部分）
                String className = fileName.substring(0, fileName.length() - 6);
                classNameList.add(className);
            }
        }

        return classNameList;

    }
}
