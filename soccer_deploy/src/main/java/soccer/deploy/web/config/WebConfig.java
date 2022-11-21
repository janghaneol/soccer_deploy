package soccer.deploy.web.config;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import soccer.deploy.web.filter.LoginCheckFilter;



@Configuration
public class WebConfig implements WebMvcConfigurer{

	// 필터 등록을 위한 빈 설정
	/*
	 * @Bean public FilterRegistrationBean logFilter() {
	 * FilterRegistrationBean<Filter> filterRegistrationBean = new
	 * FilterRegistrationBean<Filter>(); filterRegistrationBean.setFilter(new
	 * LogFilter()); filterRegistrationBean.setOrder(1);
	 * filterRegistrationBean.addUrlPatterns("/*");
	 * filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,
	 * DispatcherType.ERROR); return filterRegistrationBean; }
	 */

	@Bean
	public FilterRegistrationBean loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
		filterRegistrationBean.setFilter(new LoginCheckFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
		return filterRegistrationBean;
	}
	
	

}
