package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
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

	/**
	 * 인터셉터도 등록 가능하다
	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addInterceptors(registry);
//	}
	
	/**
	 * 컨트롤러가 여러개일 경우 전역적으로 '@CrossOrigin("*")'을 적용할 수 있다.
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST");
	}
}
