package com.ssafy.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// 해당 클래스로 WebConfig.java와 DBConfig.java 총집합
// @SpringBootApplication안에 @SpringBootConfiguration 덕분에 가능
// 또한 WebMvcConfigurer implements 하기

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.product.model.dao")
public class SpringBootProduct22Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProduct22Application.class, args);
	}
	
	/**
	 *  application.properties에 등록해둔 것 가져오기
	 */
	@Value("${spring.mvc.view.prefix}")
	private String prefix;

	@Value("${spring.mvc.view.suffix}")
	private String suffix;

	
	/**
	 * ViewResolver를 Bean 객체로 등록
	 * prefix, suffix (property 설정)은 application.properties에 등록해둔 것 가져와서 쓸 것임
	 * @return
	 */
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class);  // pom.xml에 등록해둔 것

		return resolver;
	}
	
	
	/**
	 * 정적 리소스 등록
	 * swagger 등록
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//넣지 않았을 때와 넣고 나서  (list2.jsp 에서 이미지를 읽을 수 있는지 없는지가 갈림 확인해볼것)
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST");
	}

}
