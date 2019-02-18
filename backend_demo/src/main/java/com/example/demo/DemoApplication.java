package com.example.demo;

import java.util.Locale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.example.demo.filter.AccessLogFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(value= {"com.example.demo.mapper"})
@EnableTransactionManagement
@EnableSwagger2
public class DemoApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/**
	 * swagger 설정
	 * @return
	 */
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller."))
				.paths(PathSelectors.any()).build();
	}
	
	/**
	 * AccessLog filter 설정
	 * @return
	 */
	@Bean
	public FilterRegistrationBean accessLogFilterBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AccessLogFilter());
		return registrationBean;
	}
	
	/**
	 * 세션 및 쿠기 locale 설정
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.KOREA);
		return localeResolver;
	}
	
	/**
	 * parameter:lang 인터셉터 설정
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	/**
	 * 인터셉터 등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}

