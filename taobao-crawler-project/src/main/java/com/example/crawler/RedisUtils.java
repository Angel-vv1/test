package com.example.crawler;

import redis.clients.jedis.Jedis;

public class RedisUtils {
    private Jedis jedis = new Jedis("hadoop01", 6379);

    public static void addZhizhongSeedUrl(String url) {
        jedis.sadd("zhizhong_seed_urls", url);
    }

    public static java.util.Set<String> getZhizhongSeedUrls() {
        return jedis.smembers("zhizhong_seed_urls");
    }
    
    public void addToQueue(String url) {
        jedis.rpush("url_queue", url);
    }

    public String getFromQueue() {
        return jedis.lpop("url_queue");
    }

    public boolean isCrawled(String url) {
        return jedis.sismember("crawled_urls", url);
    }

    public void markAsCrawled(String url) {
        jedis.sadd("crawled_urls", url);
    }
}
