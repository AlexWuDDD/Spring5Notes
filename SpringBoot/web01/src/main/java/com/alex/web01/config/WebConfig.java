package com.alex.web01.config;

import com.alex.web01.bean.Pet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer{
  

  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
    HiddenHttpMethodFilter  methodFilter = new HiddenHttpMethodFilter();
    methodFilter.setBeanName("_m");
    return methodFilter;
  }

  @Bean
  public WebMvcConfigurer webMvcConfigurer(){
    return new WebMvcConfigurer() {
      @Override
      public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
      }

      @Override
      public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Pet>() {
          
          @Override
          public Pet convert(String source) {
            if(!ObjectUtils.isEmpty(source)){
              Pet pet = new Pet();
              String[] split = source.split(",");
              pet.setName(split[0]);
              pet.setAge(Integer.parseInt(split[1]));
              return pet;
            }
            return null;
          }
        });
      }
    };
  }

  // @Override
  // public void configurePathMatch(PathMatchConfigurer configurer) {
  //   UrlPathHelper urlPathHelper = new UrlPathHelper();
  //   urlPathHelper.setRemoveSemicolonContent(false);
  //   configurer.setUseSuffixPatternMatch(false);
  // }

}