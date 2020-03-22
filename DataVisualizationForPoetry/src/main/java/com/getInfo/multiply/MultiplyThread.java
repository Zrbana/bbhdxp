package com.getInfo.multiply;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import javax.sql.DataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MultiplyThread
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/22 20:44
 */


public class MultiplyThread {

    private static class Job implements Runnable{

        private String url;
        private MessageDigest messageDigest;
        private DataSource dataSource;

        public Job(String url,MessageDigest messageDigest,DataSource dataSource){

            this.url = url;
            this.messageDigest = messageDigest;
            this.dataSource = dataSource;
        }

        @Override
        public void run() {

            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);

            try {
                HtmlPage detailPage = webClient.getPage(url);
                String xpath;
                DomText domText;
                //标题
                xpath = "//div[@class='cont']/h1/text()";
                domText = (DomText) detailPage.getBody().getByXPath(xpath);
                String title = domText.asText();


                //朝代
                xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
                domText = (DomText) detailPage.getBody().getByXPath(xpath);
                String dynasty = domText.asText();

                //作者
                xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
                domText = (DomText) detailPage.getBody().getByXPath(xpath);
                String author = domText.asText();

                //正文
                xpath = "//div[@class='cont']/div[@class='contson']";
                HtmlElement element = (HtmlElement) detailPage.getBody().getByXPath(xpath).get(0);
                String content = element.getTextContent().trim();

                //1.计算sha256
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

                String s = title+content;
                messageDigest.update(s.getBytes("UTF-8"));
                byte[] result = messageDigest.digest();
                StringBuilder sha256 = new StringBuilder();
                for(byte b:result){
                    sha256.append(String.format("%02x",b));
                }

                //2.计算分词
                List<Term> termList = new ArrayList<>();
                termList.addAll(NlpAnalysis.parse(title).getTerms());
                termList.addAll(NlpAnalysis.parse(content).getTerms());
                List<String> words = new ArrayList<>();
                for(Term term:termList){

                    if(term.getNatureStr().equals("w")){
                        continue;
                    }
                    if(term.getNatureStr().equals("null")){
                        continue;
                    }
                    words.add(term.getRealName());
                }

                String insertWords = String.join(",","words");


                //3.存入数据库
                MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
                dataSource.setServerName("127.0.0.1");
                dataSource.setPassword("3306");
                dataSource.setUser("root");
                dataSource.setPassword("root");
                dataSource.setDatabaseName("tangshi");
                dataSource.setUseSSL(false);
                dataSource.setCharacterEncoding("UTF-8");

                Connection connection = (Connection) dataSource.getConnection();
                String sql = "INSERT INTO tangshi " +
                        "(sha256, dynasty, title, author, " +
                        "content, words) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = null;
                statement.setString(1,sha256.toString());
                statement.setString(2,dynasty);
                statement.setString(3,title);
                statement.setString(4,author);
                statement.setString(1,content);
                statement.setString(1,insertWords);

                statement.executeUpdate();
                System.out.println(title+"插入成功");
            } catch (IOException | SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        WebClient webClient =new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        String baseUrl = "https://so.gushiwen.org";
        String pathUrl = "/gushi/tangshi.aspx";

        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();

        String url  = baseUrl+pathUrl;
        HtmlPage page = webClient.getPage(url);

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        //存放详情页的url
        List<String> detailsUrlList = new ArrayList<>();
        //列表页的解析
        List<HtmlElement> divs = page.getBody().getElementsByAttribute("div","class","typecont");
        for(HtmlElement div:divs){
            List<HtmlElement> as = div.getElementsByTagName("a");
            for(HtmlElement a:as){
                //得到的是详情页的url
                String detailsUrl = a.getAttribute("href");
                detailsUrlList.add(baseUrl+detailsUrl);
            }
        }

        //详情页的请求和解析
        for(String urls:detailsUrlList){
            Thread thread = new Thread(new Job(url,messageDigest,dataSource));
            thread.start();
        }
    }
}
