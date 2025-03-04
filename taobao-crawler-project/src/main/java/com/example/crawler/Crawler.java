package com.example.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crawler {
    private RedisUtils redisUtils;
    private ProxyPool proxyPool;

    public Crawler() {
        this.redisUtils = new RedisUtils();
        this.proxyPool = new ProxyPool();
    }

    public void startCrawling() {
        while (true) {
            String url = redisUtils.getFromQueue();
            if (url == null) {
                break;
            }
            if (redisUtils.isCrawled(url)) {
                continue;
            }
            try {
                Map<String, String> headers = new HashMap<>();
                headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                headers.put("Referer", "https://www.taobao.com");
                String html = HttpUtils.sendRequest(url, headers);
                List<String> productInfoList = PageParser.parseProductInfo(html);
                DataSender.sendData(productInfoList);
                redisUtils.markAsCrawled(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
