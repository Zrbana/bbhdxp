import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<HashMap<String, String>> list = getInfo.getHospitalInfo("http://yyk.39.net/shanxi2/hospitals/", "gbk");
        for(HashMap<String, String> map: list) {
            System.out.println("图片 ：" + map.get("img"));
            System.out.println("医院名称：" + map.get("title"));
            System.out.println("------------------------------------");
        }
    }
}
