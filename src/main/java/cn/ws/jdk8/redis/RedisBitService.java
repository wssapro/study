package cn.ws.jdk8.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-03-30 18:30
 */
public class RedisBitService {

    public static final int REDISDATAEXPIRATIONTIME = 10800;

    public static JedisPool jedisPool; // 池化管理jedis链接池

    static
    {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(300);
        // 设置最大空闲数
        config.setMaxIdle(600);
        // //设置超时时间
        config.setMaxWaitMillis(10000);
        // 初始化连接池
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    /**
     * 获取 redis链接
     *
     * @return 2017年9月13日
     */
    public static Jedis getResource()
    {
        return jedisPool.getResource();
    }

    public void setBit(String key,Long offset,boolean bool){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setbit(key,offset,bool);
        } catch (Exception e) {

        } finally {
            jedis.close();
        }
    }
    public Boolean getBit(String key,Long offset){
        Jedis jedis = null;
        boolean result = false;
        try {
            jedis = jedisPool.getResource();
            result = jedis.getbit(key, offset);
        } catch (Exception e) {

        } finally {
            jedis.close();
        }
        return result;
    }

    public Long bitCount(String key){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.bitcount(key);
        } catch (Exception e) {

        } finally {
            jedis.close();
        }
        return result;
    }
}
