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
 * �씤利� 泥댄겕 �븘�꽣 濡쒓렇�씤 �릺吏� �븡�� �궗�슜�옄�뒗 �쉶�썝 紐⑸줉 �벑�쓣 �젒洹쇳븯吏� 紐삵븯寃� �꽕�젙
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
//			// 濡쒓렇�씤 泥댄겕媛� �븘�슂�븳 URI�씤吏�
//			if (isLoginCheckUri(requestURI)) {
//				Cookie[] cookies = httpRequest.getCookies();
//				// 濡쒓렇�씤�씠 �븘�슂�븳 �궗�슜�옄�씤吏�
//				if(isLoginCheckMember(cookies)) {
//					log.info("誘몄씤利� �궗�슜�옄 �슂泥� {}", requestURI);
//					// 濡쒓렇�씤 �솕硫댁쑝濡� 由щ떎�씠�젆�듃
//					httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
//					return;
//				}
//			}
//			chain.doFilter(request, response);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		/*Session�쓣 �씠�슜*/
		try {
		if(isLoginCheckUri(requestURI)) {
			HttpSession session = httpRequest.getSession(false);
			if(session == null || session.getAttribute("loginUser")==null) {
				log.info("誘몄씤利� �궗�슜�옄 �슂泥� {}",requestURI);
				httpResponse.sendRedirect("/user/login?redirect=" + requestURI);
				return;
					}
				}
				chain.doFilter(httpRequest, httpResponse);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	/** �솕�씠�듃 由ъ뒪�듃�쓽 寃쎌슦 �씤利� 泥댄겕�븯吏� �븡�쓬 */
	private boolean isLoginCheckUri(String requestURI) {
		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
	}
	
	/** 濡쒓렇�씤 �뿬遺� 泥댄겕 Cookie 
	
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
