package com.alex.jedis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * Unit test for simple App.
 */
public class JedisTest 
{
    Jedis jedis = null;

    @Before
    public void init()
    {
        jedis = new Jedis("127.0.0.1", 55000);
        jedis.auth("redispw");
        String value = jedis.ping();
        assertEquals("PONG", value);
    }

    @After
    public void destroy()
    {
        jedis.close();
    }

    @Test
    public void testOperateKeyString()
    {
        //add
        jedis.set("name", "alex");
        //multi add
        jedis.mset("k1", "v1", "k2", "v2");
        //get
        String value = jedis.get("name");
        System.out.println("name:" + value);
        // multi get
        List<String> values = jedis.mget("k1", "k2");
        System.out.println("k1:" + values.get(0));
        System.out.println("k2:" + values.get(1));

        Set<String> keys = jedis.keys("*");
        for (String key : keys){
            System.out.println(key);
        }
    }

    @Test
    public void testOperateKeyList()
    {
        //add
        jedis.lpush("kl1", "v1", "v2", "v3");
        //get
        List<String> values = jedis.lrange("kl1", 0, -1);
        for (String value : values){
            System.out.println(value);
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys){
            System.out.println(key);
        }
    }

    @Test
    public void testOperateKeySet()
    {
        //add
        jedis.sadd("ks1", "v1", "v2", "v3", "v1");
        //get
        Set<String> values = jedis.smembers("ks1");
        for (String value : values){
            System.out.println(value);
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys){
            System.out.println(key);
        }
    }

    @Test
    public void testOperateKeyHash()
    {
        //add
        jedis.hset("kh1", "k1", "v1");
        jedis.hset("kh1", "k2", "v2");
        jedis.hset("kh1", "k3", "v3");
        //get
        Map<String,String> values = jedis.hgetAll("kh1");
        for ( Map.Entry<String, String> e: values.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys){
            System.out.println(key);
        }
    }

    @Test
    public void testOperateKeyZset()
    {
        //add
        jedis.zadd("china", 100, "shanghai");
        jedis.zadd("china", 200, "beijing");
        jedis.zadd("china", 300, "shenzheng");
        //get
        List<String> values = jedis.zrange("china", 0, -1);
        for (String value : values){
            System.out.println(value);
        }

        Set<String> keys = jedis.keys("*");
        for (String key : keys){
            System.out.println(key);
        }
    }
}
