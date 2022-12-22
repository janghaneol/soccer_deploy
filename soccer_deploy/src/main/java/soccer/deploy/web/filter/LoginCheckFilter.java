package soccer.deploy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.PatternMatchUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 인증 체크 필터 로그인 되지 않은 사용자는 회원 목록 등을 접근하지 못하게 설정
 */
@Slf4j
public class LoginCheckFilter implements Filter {

	private static final String[] whitelist = { "/", "/css/*", "/fonts/*", "/js/*", "/user/regist" , "/images/*",
			"/user/login", "/user/logout" ,"/xMain"};

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = httpRequest.getRequestURI();
		
		
		// Cookie Filter
//		try {
//			// 로그인 체크가 필요한 URI인지
//			if (isLoginCheckUri(requestURI)) {
//				Cookie[] cookies = httpRequest.getCookies();
//				// 로그인이 필요한 사용자인지
//				if(isLoginCheckMember(cookies)) {
//					log.info("미인증 사용자 요청 {}", requestURI);
//					// 로그인 화면으로 리다이렉트
//					httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
//					return;
//				}
//			}
//			chain.doFilter(request, response);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		/*Session을 이용*/
		try {
		if(isLoginCheckUri(requestURI)) {
			HttpSession session = httpRequest.getSession(false);
			if(session == null || session.getAttribute("loginUser")==null) {
				log.info("미인증 사용자 요청 {}",requestURI);
				httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
				return;
					}
				}
				chain.doFilter(httpRequest, httpResponse);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	/** 화이트 리스트의 경우 인증 체크하지 않음 */
	private boolean isLoginCheckUri(String requestURI) {
		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
	}
	
	/** 로그인 여부 체크 Cookie 
	
	private boolean isLoginCheckMember(Cookie[] cookies) {
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase("loginUser")) {
					return false;
				}
			}
		}
		return true;
	}
	*/

	@Override
	public void destroy() {
	}

}
