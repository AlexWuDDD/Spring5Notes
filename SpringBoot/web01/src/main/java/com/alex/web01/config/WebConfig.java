package com.alex.web01.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alex.web01.bean.Pet;
import com.alex.web01.converter.AlexMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
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

      @Override
      public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new AlexMessageConverter());
      }

      @Override
      public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        Map<String, MediaType> mediaTypes = new HashMap<>();

        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("alex", MediaType.parseMediaType("application/x-alex"));

        ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
        
        HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

        configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
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
