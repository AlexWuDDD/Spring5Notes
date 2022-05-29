package com.alex.jedis;

import java.util.Random;

import redis.clients.jedis.Jedis;

public class PhoneCode {
  

  //1.生成六位数字验证码
  public static String getCode(){
    Random random = new Random();
    String code = "";
    for(int i = 0; i < 6; ++i){
      int rand = random.nextInt(10);
      code += rand;
    }
    return code;
  }

  //每个收集每天只能发送三次，验证码放到redis中，设置过期时间
  public static void setVerifyCode(String phone){
    //连接redis
    Jedis jedis = new Jedis("127.0.0.1", 55000);
    jedis.auth("redispw");

    //拼接key
    //手机发送次数
    String countKey = "VerifyCode:" + phone + ":count";
    //验证码key
    String codeKey = "VerifyCode:" + phone + ":code";
    
    //每个收集每天只能发送三次
    String count = jedis.get(countKey);
    if(count == null){
      jedis.set(countKey, "1");
    }else{
      int countInt = Integer.parseInt(count);
      if(countInt >= 3){
        System.out.println("每天只能发送三次");
        jedis.close();
        return;
      }
      else{
        jedis.incr(countKey);
      }
    }

    //验证码放到redis中，设置过期时间
    jedis.setex(codeKey, 120, getCode());

    jedis.close();
  }

  //验证验证码是否正确
  public static boolean verifyCode(String phone, String code){
    //连接redis
    Jedis jedis = new Jedis("127.0.0.1", 55000);
    jedis.auth("redispw");

    //拼接key
    //验证码key
    String codeKey = "VerifyCode:" + phone + ":code";
    String redisCode = jedis.get(codeKey);

    //判断
    if(redisCode.equals(code)){
      System.out.print("成功");
      jedis.close();
      return true;
    }
    else{
      System.out.print("失败");
      jedis.close();
      return false;
    }
  }
}
