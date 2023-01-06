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
///* 占쎌뵥筌앾옙 筌ｋ똾寃� 占쎌뵥占쎄숲占쎈�롳옙苑� (嚥≪뮄�젃占쎌뵥 占쎈┷筌욑옙 占쎈륫占쏙옙 占쎄텢占쎌뒠占쎌쁽占쎈뮉 占쎌돳占쎌뜚 筌뤴뫖以� 占쎈쾻占쎌뱽 占쎌젔域뱀눛釉�筌욑옙 筌륁궢釉�野껓옙 占쎄퐬占쎌젟) */
//@Slf4j
//public class LoginCheckInterceptor implements HandlerInterceptor {
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		log.info("LoginCheckInterceptor 占쎈뼄占쎈뻬...");
//		System.out.println(request.getDispatcherType());
//		String requestURI = request.getRequestURI();
//		HttpSession session = request.getSession();
//		Object logUser = session.getAttribute("loginUser");
//		/* Cookie 獄쎻뫗�뻼
//		Cookie[] cookies = request.getCookies();
//		// 嚥≪뮄�젃占쎌뵥占쎌뵠 占쎈툡占쎌뒄占쎈립 占쎄텢占쎌뒠占쎌쁽占쎌뵥筌욑옙
//		if (isLoginCheckMember(cookies)) {
//			log.info("沃섎챷�뵥筌앾옙 占쎄텢占쎌뒠占쎌쁽 占쎌뒄筌ｏ옙 {}", requestURI);
//			// 嚥≪뮄�젃占쎌뵥 占쎌넅筌롫똻�몵嚥∽옙 �뵳�됰뼄占쎌뵠占쎌젂占쎈뱜
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
////	/** 嚥≪뮄�젃占쎌뵥 占쎈연�겫占� 筌ｋ똾寃� */
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
