package com.kpoim.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kpoim")
public class MyWebAppConfig implements WebMvcConfigurer {

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	//viewResolver.setViewClass(JstlView.class);//Not any more required
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	registry.viewResolver(viewResolver);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }

//  @Override
//  public void addFormatters(FormatterRegistry registry) {
//	registry.addConverter(new StringToEmployeeConverter());
//  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
	
//	registry.addConverter();
  }
  
}
