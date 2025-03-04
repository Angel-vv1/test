import redis.clients.jedis.Jedis;

public class RedisUtils {
    private static Jedis jedis = new Jedis("localhost", 6379);

    // 新增的添加论文数据到Redis的方法
    public static void addPaper(String paper) {
        jedis.rpush("zhiwang_papers", paper);
    }

    // 新增的关闭Jedis连接的方法
    public static void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

    // 假设之前有管理URL的方法，保留这些方法
    public static void addToQueue(String url) {
        jedis.rpush("url_queue", url);
    }

    public static String getFromQueue() {
        return jedis.lpop("url_queue");
    }

    public static boolean isCrawled(String url) {
        return jedis.sismember("crawled_urls", url);
    }

    public static void markAsCrawled(String url) {
        jedis.sadd("crawled_urls", url);
    }
}
