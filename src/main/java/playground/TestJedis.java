package playground;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

public class TestJedis {

    public static void main(String[] args){
        JedisPooled jedis = new JedisPooled("localhost", 6379);
        jedis.set("your_name", "hello_world");
        String value = jedis.get("your_name");

    }
}
