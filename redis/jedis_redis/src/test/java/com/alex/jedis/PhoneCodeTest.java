package com.alex.jedis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhoneCodeTest {
  

  @Test
  public void testGetPhobeCode(){
    String code = PhoneCode.getCode();
    assertEquals(code.length(), 6);
    System.out.println(code);
  }

  @Test
  public void testFlow(){
    PhoneCode.setVerifyCode("13800138000");
    PhoneCode.setVerifyCode("13800138000");
    PhoneCode.setVerifyCode("13800138000");
    PhoneCode.setVerifyCode("13800138000");

    PhoneCode.verifyCode("13800138000", "261773");
  }
}
