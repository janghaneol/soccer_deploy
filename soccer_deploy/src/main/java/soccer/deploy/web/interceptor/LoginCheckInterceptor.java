//package soccer.deploy.web.interceptor;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import lombok.extern.slf4j.Slf4j;
//
//
///* �씤利� 泥댄겕 �씤�꽣�뀎�꽣 (濡쒓렇�씤 �릺吏� �븡�� �궗�슜�옄�뒗 �쉶�썝 紐⑸줉 �벑�쓣 �젒洹쇳븯吏� 紐삵븯寃� �꽕�젙) */
//@Slf4j
//public class LoginCheckInterceptor implements HandlerInterceptor {
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		log.info("LoginCheckInterceptor �떎�뻾...");
//		System.out.println(request.getDispatcherType());
//		String requestURI = request.getRequestURI();
//		HttpSession session = request.getSession();
//		Object logUser = session.getAttribute("loginUser");
//		/* Cookie 諛⑹떇
//		Cookie[] cookies = request.getCookies();
//		// 濡쒓렇�씤�씠 �븘�슂�븳 �궗�슜�옄�씤吏�
//		if (isLoginCheckMember(cookies)) {
//			log.info("誘몄씤利� �궗�슜�옄 �슂泥� {}", requestURI);
//			// 濡쒓렇�씤 �솕硫댁쑝濡� 由щ떎�씠�젆�듃
//			response.sendRedirect("/members/login?redirect=" + requestURI);
//			return false;
//		}
//		*/
//		
//		if(session==null || logUser == null) {
//			response.sendRedirect("/user/login?redirect="+requestURI);
//			return false;
//		}
//		
//		return true;
//		
//	}
//	
//	
//		
////	/** 濡쒓렇�씤 �뿬遺� 泥댄겕 */
////	private boolean isLoginCheckMember(HttpSession session) {
////		if (session != null || session.getAttribute("loginUser")) {
////				return false;
////		}
////		return true;
////	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//			
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {}
//
//}
