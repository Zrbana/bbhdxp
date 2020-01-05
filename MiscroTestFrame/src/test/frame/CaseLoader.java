package test.frame;

import test.frame.annotation.BenchMark;
import test.frame.annotation.Case;
import test.frame.annotation.MeasureMent;
import test.frame.annotation.WarmUp;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 自动加载被测试类
 */
public class CaseLoader {
    //返回一个List集合，包含所有测试类的名称
    //得到名称就可以得到待测类的Class类，进一步得到他的实例化对象
    public List<String> load() throws IOException {
        List<String> classNameList = new ArrayList<>();
        //定义你放测试文件的那个包的路径
        String pkg = "www/yy/main/cases/";
        ClassLoader classLoader = this.getClass().getClassLoader();
        //返回的是一个迭代器，存放着对应的URL
        Enumeration<URL> urls = classLoader.getResources(pkg);
        while(urls.hasMoreElements()) {
            URL url = urls.nextElement();
            //getProtocol()函数作用是返回该URL的协议名称，例如file
            if(!url.getProtocol().equals("file")) {
                continue;
            }
            //获取该URL的路径，并用decode函数进行转码，不转码的话会出现乱码
            String dirname = URLDecoder.decode(url.getPath(),"UTF-8");
            File dir = new File(dirname);
            if(!dir.isDirectory()) {      //如果不是目录文件
                continue;
            }
            File[] files = dir.listFiles();    //获取这个目录下的所有文件
            //若为空，则跳过
            if(files == null) continue;
            for(File file:files) {
                String fileName = file.getName();

                //这里的split分割函数里用.分割时，务必加上转义字符，因为这里的参数是一个正则表达式，而.在正则表达式
                //里表示全字符匹配的意思
                String[] str = fileName.split("\\.");
                //判断这个文件是不是class文件，如果不是，直接跳过
                //判断方法：用.分割类名后，获取最后一个元素，即后缀名，即可判断
                if(!(str[str.length-1].equals("class"))) {
                    continue;
                }
                //获取该class文件的名称（即除去.class的那一部分）
                String className = fileName.substring(0,fileName.length()-6);
                classNameList.add(className);
            }
        }

        return classNameList;


    }
}

class caseRunner{
    public static List<Case> InitCase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        caseRunner caseRunner = new caseRunner();
        List<Case> list = caseRunner.buildCase(new CaseLoader());
        return list;
    }

    //返回List对象，存放的是当前Cases包下所有类的实例化对象
    public List<Case> buildCase(CaseLoader caseLoader) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<String> classNameList = new ArrayList<>();
        List<Case> caseList = new ArrayList<>();
        classNameList = caseLoader.load();
        for(String name:classNameList){
            Class bCaseClass = Class.forName("test.frame.cases");
            //获取测试类的实例化对象
            Case bCase = (Case)bCaseClass.newInstance();
            caseList.add(bCase);
        }
        return caseList;
    }

    public void runCase(Case bCase) throws InvocationTargetException, IllegalAccessException {
        int iterations = 100;//第一组测试数的初始默认值
        int group = 10;//组数默认值
        int iterationWarmUp = 10;//预热默认值

        //获取该类的Class对象
        Class<?> cls = bCase.getClass();

        //获取该类的注解信息
        Annotation measurmentW = cls.getAnnotation(MeasureMent.class);
        //第一层注解信息
        if(measurmentW!=null){
            MeasureMent measureMent = (MeasureMent) measurmentW;
            iterations = measureMent.iterations();
            group = measureMent.group();
        }
        //没有第一层注解信息在使用第二层注解信息
        Method[] methods = cls.getMethods();
        for(Method method:methods){
            //获取该类的方法的注解信息
            Annotation benchmark = method.getAnnotation(BenchMark.class);
            if(benchmark==null){
                continue;
            }
            MeasureMent measureMent = method.getAnnotation(MeasureMent.class);
            //如果测试方法中有设置好的注解参数，就将它读出来
            if(measureMent!=null){
                iterations  = (measureMent).iterations();
                group = (measureMent).group();
            }
            //预热部分，如果没有预热注解，就不会进行预热
            WarmUp warmUp = method.getAnnotation(WarmUp.class);
            if(warmUp!=null){
                iterationWarmUp= (warmUp).interations();
            }else{
                iterationWarmUp =0;
            }
            //在调用具体实现方法
            run(bCase,method,iterations,group,iterationWarmUp);
        }
    }


    //真正检测时间的方法
    public void run(Case bCase,Method method,int iterations,int group,int iterationsWarmUp) throws InvocationTargetException, IllegalAccessException {
        String caseName = bCase.getClass().getName();
        String methodName = method.getName();
        System.out.println("This is the test report for the "+caseName+","+methodName);
        //预热检测部分
        if(iterationsWarmUp != 0) {
            System.out.println("————————————————————————");
            System.out.println("start warming up");
            for(int k=0; k<iterationsWarmUp; k++) {
                System.out.print("Warming up number "+(k+1)+"|");
                long timeStart = System.nanoTime();
                for(int i=0; i<iterationsWarmUp;i++) {
                    method.invoke(bCase);
                }
                long timeEnd = System.nanoTime();
                long time = timeEnd - timeStart;
                System.out.println(" elapsed time："+time/10+" ns");
            }
            System.out.println("warm up finished..........");
            System.out.println("————————————————————————");
        }
        int totleTime = 0;
        for (int i=0; i<group; i++) {
            System.out.println("Testing begin:");
            System.out.print("Testing number "+(i+1)+"|");
            long timeStart = System.nanoTime();
            for(int j=0; j<iterations; j++) {
                method.invoke(bCase);
            }
            long timeEnd = System.nanoTime();
            long time = timeEnd - timeStart;
            totleTime += time/iterations;
            System.out.println(" elapsed time："+time/iterations+" ns");
        }
        System.out.println("The average time："+totleTime/group+ " ns");
        System.out.println("conver to ms:"+totleTime/group/1000000+"ms");
        System.out.println("Complete this test!");
    }
}











