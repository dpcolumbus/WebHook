package com.osi.cc.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration 
@ComponentScan("com.osi.cc") 
@EnableWebMvc   
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Value("${constant.contact.api.key}")
	private String apikey;
	
	@Value("${constant.contact.api.token}")
	private String apiToken;
	
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }	
   
   
    
   
    
    @Bean("mapper")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper getJsonMapper() {
    	
    	ObjectMapper mapper=new ObjectMapper();
       return mapper;
    }
} 