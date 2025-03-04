import redis.clients.jedis.Jedis;

public class RedisUtils {
    private static Jedis jedis = new Jedis("localhost", 6379);

    public static void addPaper(String paper) {
        jedis.rpush("zhiwang_papers", paper);
    }

    public static void close() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
