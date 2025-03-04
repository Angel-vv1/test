package com.example.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class PageParser {
    public static List<String> parseProductInfo(String html) {
        List<String> productInfoList = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        // 根据淘宝实际页面结构调整选择器
        Elements items = doc.select(".item.J_MouserOnverReq");
        for (Element item : items) {
            String title = item.select(".row.row-2.title").text();
            String price = item.select(".price.g_price.g_price-highlight").text();
            String info = "Title: " + title + ", Price: " + price;
            productInfoList.add(info);
        }
        return productInfoList;
    }
}
