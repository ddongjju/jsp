package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

/*
 	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>
 */

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})})
//<mvc:annotation-driven/>
@EnableWebMvc
public class ApplicationContext extends WebMvcConfigurerAdapter{
	
	//<mvc:default-servlet-handler/> ==> interface구현(WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/*
	 	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"></bean>
		<bean id="profileDownloadView" class="kr.or.ddit.mvc.view.ProfileDownloadView"></bean>
		<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"></bean>
		<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"></bean>
	 */
	@Bean
	public ExcelDownloadView excelView() {
		ExcelDownloadView excelView = new ExcelDownloadView();
		
		return excelView;
	}
	
	@Bean
	public ProfileDownloadView profileDownloadview() {
		ProfileDownloadView profileDownloadview = new ProfileDownloadView();
		
		return profileDownloadview;
	}
	
	@Bean
	public ProfileImgView profileImgView() {
		ProfileImgView profileImgView = new ProfileImgView();
		
		return profileImgView;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		
		return jsonView;
	}
	
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfingurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		return tilesConfigurer;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResouceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error/");
	}

}
