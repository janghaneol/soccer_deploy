//package soccer.deploy.web.config;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import soccer.deploy.web.filter.LoginCheckFilter;
//import soccer.deploy.web.interceptor.LoginCheckInterceptor;
//
//
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer{
//
//	// �븘�꽣 �벑濡앹쓣 �쐞�븳 鍮� �꽕�젙
//	/*
//	 * @Bean public FilterRegistrationBean logFilter() {
//	 * FilterRegistrationBean<Filter> filterRegistrationBean = new
//	 * FilterRegistrationBean<Filter>(); filterRegistrationBean.setFilter(new
//	 * LogFilter()); filterRegistrationBean.setOrder(1);
//	 * filterRegistrationBean.addUrlPatterns("/*");
//	 * filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,
//	 * DispatcherType.ERROR); return filterRegistrationBean; }
//	 */
//
////	@Bean
//	public FilterRegistrationBean loginCheckFilter() {
//		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
//		filterRegistrationBean.setFilter(new LoginCheckFilter());
//		filterRegistrationBean.setOrder(1);
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
//		return filterRegistrationBean;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginCheckInterceptor())
//		        .order(1)
//		        .addPathPatterns("/**")
//		        .excludePathPatterns(
//		        		"/", "/*.ico", "/css/**", "/fonts/**", "/js/**", "/images/**", 
//		        		"/user/regist","/user/login", "/user/logout", "/error", "/error/**" , "/images/profile/**");
//	}
//}
//
