import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class getInfo {

    public static String getHtmlInfoFromUrl(String url, String encoding) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL urlObj = new  URL(url);
            URLConnection uc = urlObj.openConnection();
            isr = new InputStreamReader(uc.getInputStream(), encoding);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = sb.toString();
        //System.out.println(str);
        return str;

    }


    /**
     * @param url  网址
     * @param encoding 解码方式
     */

    public static List<HashMap<String, String>> getHospitalInfo(String url, String encoding) {
        String html = getHtmlInfoFromUrl(url, encoding);
        org.jsoup.nodes.Document document = Jsoup.parse(html);
        Elements elementList = document.getElementsByTag("li");
        List<HashMap<String, String>> maps =  new ArrayList<HashMap<String, String>>();
        for(org.jsoup.nodes.Element element: elementList){
            String img = element.getElementsByClass("yy-img").attr("src");
            String title = element.getElementsByClass("yy-name").attr("title");
            if(img != "" && title != "") {//筛选li标签
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("img", img);
                map.put("title", title);
                maps.add(map);
            }
        }
        return maps;
    }

}
