package Demo;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * @ClassName HtmlunitDemo
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/4 11:38
 */


public class HtmlunitDemo {
    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage page =  webClient.getPage("https://www.gushiwen.org/gushi/tangshi.aspx");
        System.out.println(page);
    }
}
