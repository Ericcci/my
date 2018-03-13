package com.freetime.my.util;

import com.freetime.my.repository.DataBasePipeline;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Description:</b><br>
 *
 * @author Eric.
 * @version 1.0
 *          <b>ProjectName:</b> my
 *          <br><b>PackageName:</b> com.freetime.my.util
 *          <br><b>Date:</b> 2018/3/13 10:56
 */
@Slf4j
public class GithubRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
//        List<String> urls = page.getHtml().css("ul.list").links().all();
        //爬取电影的标题和链接
//        page.addTargetRequests(urls);
//        page.putField("title", Jsoup.parse("<html>" + page.getHtml().$("#main > div.col6 > div > h1") + "</html>").select("h1").text());
//        page.putField("url", Jsoup.parse("<html>" + page.getHtml().$("#endText > table > tbody > tr:nth-child(1) > td > a") + "</html>").select("a").attr("href"));

        //爬取下一页的内容
        List<String> next = page.getHtml().$("#main > div.col4 > div > div:nth-child(2) > a:nth-child(4)").links().all();
        page.addTargetRequests(next);

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor())
                .addUrl("http://www.hao6v.com/s/kehuan/index.html")
                .addPipeline(new DataBasePipeline())
                .thread(5)
                .run();
    }
}
