package java7.daily.learning.prac;

import java.util.*;

/**
 * @ClassName ErrorCount
 * @Description
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * @Author yuisama
 * @Date 2020/3/12 22:45
 */

//把文件名和行号作为 key，出现次数作为 value 即可。但有几个地方要特别注意
public class ErrorCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
// 这里必须用，LinkedHashMap，按插入顺序排序。随后之后会按照出错次数再排序，但如果出错次数一样，还是要按照插入的顺序来
// 所以这里必须用 LInkedHashMap
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while(in.hasNext()){
            String path = in.next();
            int id = path.lastIndexOf('\\');
            String filename = id == -1 ? path : path.substring(id + 1);
            int line = in.nextInt();
//统计频率
            String key = filename + " " + line;
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        } // 对记录进行排序，这里有个前提，就是 java 中的排序用的是归并排序，是稳定排序
// 这样，如果出错次数一样多，仍然保持插入顺序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
//只输出前8条
        int m = 0;
        for(Map.Entry<String, Integer> mapping : list){
            if (m >= 8) {
                break;
            }
            String[] str = mapping.getKey().split(" ");
            String filename = str[0];
            if (filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            String n = str[1];
            Integer count = mapping.getValue();
            System.out.printf("%s %s %d%n", filename, n, count);
            m++;
        }
    }
}
