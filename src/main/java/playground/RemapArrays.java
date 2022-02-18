package playground;


import redis.clients.jedis.JedisPooled;

public class RemapArrays {
    public static void main(String[] args) {
        JedisPooled jedisPooled = new JedisPooled("localhost", 6379);
        jedisPooled.sadd("name", "rs");
        System.out.println("Value is: " + jedisPooled.get("name"));
    }


}
