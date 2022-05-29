package com.alex.jedis;

import redis.clients.jedis.Jedis;

public class JedisDemo1 {
  
  public static void main(String[] args) {
    //创建Jedis对象
    Jedis jedis = new Jedis("127.0.0.1", 55000);
    jedis.auth("redispw");
    String value = jedis.ping();
    System.out.println(value);
    jedis.close();
    return;
  }
}
