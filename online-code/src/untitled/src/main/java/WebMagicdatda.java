/**
 * @ClassName WebMagicdatda
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/26 23:37
 */

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicdatda {
//第一部分：爬取hao123网站首页主体部分的其它网站的首页
//
//view plain copy
 public class Test1 implements PageProcessor {
        // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
        private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
        // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
        public void process(Page page) {
            System.out.println(page.getUrl());
            String title = page.getHtml().xpath("//head/title/text()").toString();
            System.out.println(title);
            if (title == null) {
                page.setSkip(true);
            }
            page.putField("allhtml", page.getHtml().toString());
            // 部分三：从页面发现后续的url地址来抓取
            // 采集该网站新闻列表页
            page.addTargetRequests(page.getHtml().links().regex("(http://sousuo.gov.cn/column/30611/\\d+.htm)").all());
            // 采集该网站每条新闻详细页
            page.addTargetRequests(
                    page.getHtml().links().regex("(http://www.gov.cn/xinwen/2017-\\d+/\\d+/content_\\d+.htm)").all());
        }
        public Site getSite() {
            return site;
        }
        public static void main(String[] args) {
            Spider.create(new Test1())
                    // 从"http://sousuo.gov.cn/column/30611/0.htm"开始抓
                    .addUrl("http://sousuo.gov.cn/column/30611/0.htm")
                    // 抓取页面的存储路径
                    .addPipeline(new FilePipeline("/data/pachong/govnews"))
                    // 开启5个线程抓取
                    .thread(5)
                    // 启动爬虫
                    .run();
        }
    }

    //第一部分：爬取hao123网站首页主体部分的其它网站的首页
    //
    //view plain copy
    public static void main(String[] args) throws IOException {

        Spider.create(new Webmagicdata())
                .addUrl("http://www.hao123.com/")
                .addPipeline(new ConsolePipeline())
                .thread(5)
                .run();
    }
}
