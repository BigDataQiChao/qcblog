package com.qcblog.util;

import com.qcblog.mapper.CmsContentMapper;
import com.qcblog.pojo.CmsContent;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class CrawlbysocketUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlbysocketUtil.class);
    private static final String HTTPURL = "https://www.csdn.net/";

    private static CmsContentMapper cmsContentMapper;
    @Autowired
    public CrawlbysocketUtil(CmsContentMapper cmsContentMapper) {
        CrawlbysocketUtil.cmsContentMapper=cmsContentMapper;
    }

    @Scheduled(cron = "${webmagic.cron}")
    public static void crawlbysocket() throws Exception {
        //获取目标网站网页
        String html = HttpClientUtils.getHtml(HTTPURL, "utf-8");
        CmsContent cmsContent = new CmsContent();
        //解析网页
        Document doc = Jsoup.parse(html);
        //提取 a 标签
        Elements select = doc.select("ul li .list_con .title h2 a");
       /* Elements select = doc.select("article header h2 a");*/
        //循环a标签
        for (Element e : select) {
            //创建一个list
            List<CmsContent> list = new ArrayList<CmsContent>();
            int i = select.indexOf(e) + 1;
            //文章标题
            String title = e.text();
            //获取href
            String href = e.attr("href");
            String chtml = HttpClientUtils.getHtml(href, "utf-8");
            log.info("获取第" + i + "篇文章");
            log.info("标题：" + title);
            log.info("url-->" + href);
            log.info("获取时间-->" + new Date());
            //获取详情页
            Document texthtml = Jsoup.parse(chtml);
            //获取内容
            Elements select1 = texthtml.select("article .article_content #content_views");
            String htmltext = select1.html();
          /*  Pattern pattern = Pattern.compile("<p.*?>(.*?)</p>");
            Matcher mp = pattern.matcher(htmltext);*/
            cmsContent.setContent(htmltext);
            cmsContent.setId(UUID.randomUUID().toString());
            cmsContent.setTitle(title);
            cmsContent.setCtime(new Date());
            cmsContent.setStatus("1");
            list.add(cmsContent);
            for (CmsContent cms : list) {
                cmsContentMapper.insert(cms);
            }
        }
    }
}
