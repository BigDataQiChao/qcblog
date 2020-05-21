package com.qcblog.util;

import com.qcblog.pojo.CmsContent;
import com.qcblog.service.CmsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Date;
import java.util.List;

public class CsdnBlogPageUtil implements PageProcessor {

    private static String username = "stpeace";  // 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public Site getSite() {
        return site;
    }
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 列表页
        if (!page.getUrl().regex("http://blog\\.csdn\\.net/" + username + "/article/details/\\d+").match()) {
            // 添加所有文章页
            page.addTargetRequests(page.getHtml().xpath("//div[@class='article-list']").links()// 限定文章列表获取区域
                    .regex("/" + username + "/article/details/\\d+")
                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 添加其他列表页
            page.addTargetRequests(page.getHtml().xpath("//div[@id='papelist']").links()// 限定其他列表页获取区域
                    .regex("/" + username + "/article/list/\\d+")
                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 文章页
        } else {
            size++;// 文章数量加1
            // 用CsdnBlog类来存抓取到的数据，方便存入数据库
            CmsContent cmsContent = new CmsContent();
            // 设置编号
            cmsContent.setId(
                    page.getUrl().regex("http://blog\\.csdn\\.net/" + username + "/article/details/(\\d+)").get());
            // 设置标题
            cmsContent.setTitle(
                    page.getHtml().xpath("//div[@class='article-title-box']//h1[@class='title-article']/text()").get());
            //设置内容
            cmsContent.setContent(
                    page.getHtml().xpath("//div[@class='article_content']/allText()").get());
            //设置地址
            cmsContent.setUrl("http://blog.csdn.net/" + username);
            //设置爬取日志
            cmsContent.setStatus("1");
            // 设置更新日期
            cmsContent.setUtime(
                    page.getHtml().xpath("//div[@class='bar-content']/span[@class='time']/text()").get());
            // 设置类别（可以有多个，用,来分割）
            cmsContent.setSubject(listToString(page.getHtml().xpath("//div[@class='tags-box']/a/text()").all()));
            // 把对象存入数据库
            new CmsContentDaoUtil().add(cmsContent);
            /*cmsContentService.insertCmsContent(cmsContent);*/
            // 把对象输出控制台
           /* System.out.println(cmsContent);*/
        }
    }
    // 把list转换为string，用,分割
    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("【爬虫开始】...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CsdnBlogPageUtil()).addUrl("http://blog.csdn.net/" + username).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + size + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
    }
}
