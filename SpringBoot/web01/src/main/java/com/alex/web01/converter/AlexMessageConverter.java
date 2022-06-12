package com.alex.web01.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.alex.web01.bean.User;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;


/**
 * 自定义Converter
 */

public class AlexMessageConverter implements HttpMessageConverter<User>{

  @Override
  public boolean canRead(Class<?> clazz, MediaType mediaType) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canWrite(Class<?> clazz, MediaType mediaType) {
    // TODO Auto-generated method stub
    return true;
  }

  /**
   * 服务器要统计所有MessageConverter都能写出哪些内容
   * application/x-alex
   */
  @Override
  public List<MediaType> getSupportedMediaTypes() {
    return MediaType.parseMediaTypes("application/x-alex");
  }

  @Override
  public User read(Class<? extends User> clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void write(User t, MediaType contentType, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {
    //自定义协议数据的写出
    String data = t.getUserName() + ";" + t.getAge() + ";" + t.getBirth() + ";" + t.getPet().getName() + ";" + t.getPet().getAge();
    //写出去
    OutputStream body = outputMessage.getBody();
    body.write(data.getBytes());
  }

  
}
