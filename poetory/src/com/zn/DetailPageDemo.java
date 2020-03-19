package com.zn;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.io.IOException;

/**
 * @ClassName DetailPageDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/19 22:12
 */


public class DetailPageDemo {
    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        String url = "https://www.gushiwen.org/gushi/tangshi.aspx";
        HtmlElement page = webClient.getPage(url);
        HtmlElement body = page.getBody();
        // 标题
        {
            String xpath = "//div[@class='cont']/h1/text()";
            Object o = body.getByXPath(xpath).get(0);DomText domText = (DomText)o;
            System.out.println(domText.asText());
        }
        {
            String xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
            Object o = body.getByXPath(xpath).get(0);
            DomText domText = (DomText)o;
            System.out.println(domText.asText());
        }
        {
            String xpath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
            Object o = body.getByXPath(xpath).get(0);DomText domText = (DomText)o;
            System.out.println(domText.asText());
        }
        {
            String xpath = "//div[@class='cont']/div[@class='contson']";
            Object o = body.getByXPath(xpath).get(0);
            HtmlElement element = (HtmlElement)o;
            System.out.println(element.getTextContent().trim());
        }
    }
}
