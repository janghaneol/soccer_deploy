package soccer.deploy.web.interceptor;

import javax.servlet.DispatcherType;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


/* 인증 체크 인터셉터 (로그인 되지 않은 사용자는 회원 목록 등을 접근하지 못하게 설정) */
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("LoginCheckInterceptor 실행...");
		System.out.println(request.getDispatcherType());
		String requestURI = request.getRequestURI();
		/* Cookie 방식
		Cookie[] cookies = request.getCookies();
		// 로그인이 필요한 사용자인지
		if (isLoginCheckMember(cookies)) {
			log.info("미인증 사용자 요청 {}", requestURI);
			// 로그인 화면으로 리다이렉트
			response.sendRedirect("/members/login?redirect=" + requestURI);
			return false;
		}
		*/
		HttpSession session = request.getSession();
		if(session==null || session.getAttribute("loginUser")==null) {
			response.sendRedirect("/user/login?redirect="+requestURI);
			return false;
		}
		
		return true;
		
	}
	
	
		
//	/** 로그인 여부 체크 */
//	private boolean isLoginCheckMember(HttpSession session) {
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equalsIgnoreCase("loginId")) {
//					return false;
//					}
//				}
//			}
//		return true;
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {}

}
