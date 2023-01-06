//package soccer.deploy.web.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.util.PatternMatchUtils;
//import lombok.extern.slf4j.Slf4j;
//
///**
//* 占쎌뵥筌앾옙 筌ｋ똾寃� 占쎈툡占쎄숲 嚥≪뮄�젃占쎌뵥 占쎈┷筌욑옙 占쎈륫占쏙옙 占쎄텢占쎌뒠占쎌쁽占쎈뮉 占쎌돳占쎌뜚 筌뤴뫖以� 占쎈쾻占쎌뱽 占쎌젔域뱀눛釉�筌욑옙 筌륁궢釉�野껓옙 占쎄퐬占쎌젟
//*/
//@Slf4j
//public class LoginCheckFilter implements Filter {
//
//	private static final String[] whitelist = { "/", "/css/*", "/fonts/*", "/js/*", "/user/regist" , "/images/*",
//			"/user/login", "/user/logout" ,"/xMain"};
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		String requestURI = httpRequest.getRequestURI();
//		
//		
//		// Cookie Filter
////		try {
////			// 嚥≪뮄�젃占쎌뵥 筌ｋ똾寃뺝첎占� 占쎈툡占쎌뒄占쎈립 URI占쎌뵥筌욑옙
////			if (isLoginCheckUri(requestURI)) {
////				Cookie[] cookies = httpRequest.getCookies();
////				// 嚥≪뮄�젃占쎌뵥占쎌뵠 占쎈툡占쎌뒄占쎈립 占쎄텢占쎌뒠占쎌쁽占쎌뵥筌욑옙
////				if(isLoginCheckMember(cookies)) {
////					log.info("沃섎챷�뵥筌앾옙 占쎄텢占쎌뒠占쎌쁽 占쎌뒄筌ｏ옙 {}", requestURI);
////					// 嚥≪뮄�젃占쎌뵥 占쎌넅筌롫똻�몵嚥∽옙 �뵳�됰뼄占쎌뵠占쎌젂占쎈뱜
////					httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
////					return;
////				}
////			}
////			chain.doFilter(request, response);
////		} catch (Exception ex) {
////			ex.printStackTrace();
////		}
//		
//		/*Session占쎌뱽 占쎌뵠占쎌뒠*/
//		try {
//		if(isLoginCheckUri(requestURI)) {
//			HttpSession session = httpRequest.getSession(false);
//			if(session == null || session.getAttribute("loginUser")==null) {
//				log.info("沃섎챷�뵥筌앾옙 占쎄텢占쎌뒠占쎌쁽 占쎌뒄筌ｏ옙 {}",requestURI);
//				httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
//				return;
//					}
//				}
//				chain.doFilter(httpRequest, httpResponse);
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		
//	}
//
//	/** 占쎌넅占쎌뵠占쎈뱜 �뵳�딅뮞占쎈뱜占쎌벥 野껋럩�뒭 占쎌뵥筌앾옙 筌ｋ똾寃뺧옙釉�筌욑옙 占쎈륫占쎌벉 */
//	private boolean isLoginCheckUri(String requestURI) {
//		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
//	}
//	
//	/** 嚥≪뮄�젃占쎌뵥 占쎈연�겫占� 筌ｋ똾寃� Cookie 
//	
//	private boolean isLoginCheckMember(Cookie[] cookies) {
//		if(cookies != null) {
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equalsIgnoreCase("loginUser")) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	*/
//
//	@Override
//	public void destroy() {
//	}
//
//}
