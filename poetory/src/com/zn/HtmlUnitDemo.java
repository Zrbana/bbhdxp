package com.zn;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName HtmlUnitDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/19 21:10
 */

//htmlunit提取列表页信息
public class HtmlUnitDemo {
    public static void main(String[] args) throws IOException {
        //新建一个火狐浏览器的客户端对象
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //当css或js出错时是否抛出异常，这里选择不需要
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        //爬取的链接
        String url = "https://www.gushiwen.org/gushi/tangshi.aspx";
        //加载网页
        HtmlPage page = webClient.getPage(url);

        //String XPath = "//div[@class='main3']/div[@class='left']/div[@class='typecont']/a/text()";
        HtmlElement body = page.getBody();
        List<HtmlElement> elements = body.getElementsByAttribute("div","class","typecont");
        for(HtmlElement element1:elements){
            List<HtmlElement> aElements = element1.getElementsByTagName("a");
            for(HtmlElement a:aElements){
                System.out.println(a.getAttribute("href"));

            }

        }
    }
}
