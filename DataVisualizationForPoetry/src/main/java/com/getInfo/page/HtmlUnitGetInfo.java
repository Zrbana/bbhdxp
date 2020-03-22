package com.getInfo.page;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName HtmlUnitGetInfo
 * @Description 使用HTMLunit类库爬取指定页面(列表页)的内容
 * @Author yuisama
 * @Date 2020/3/21 23:37
 */


public class HtmlUnitGetInfo {
    public static void main(String[] args) throws IOException {

        try(WebClient webClient = new WebClient(BrowserVersion.CHROME)){
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            String url = "https://so.gushiwen.org/gushi/tangshi.aspx";
            HtmlPage page = webClient.getPage(url);
            HtmlElement body  = page.getBody();
            List<HtmlElement> elements = body.getElementsByAttribute(
                    "div",
                    "class",
                    "typecont"
            );

            int count = 0;
            for (HtmlElement element : elements) {
                List<HtmlElement> aElements = element.getElementsByTagName("a");
                for (HtmlElement a : aElements) {
                    System.out.println(a.getAttribute("href"));
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
