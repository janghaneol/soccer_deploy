//package soccer.deploy.match.myService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import soccer.deploy.match.myDao.matchDao;
//import soccer.deploy.match.myDto.matchMyDto;
//
//@Service
//public class matchMyService implements matchMyServiceIF{
//
//		@Autowired
//		private SqlSessionFactory sqlSessionFactory;
//		
//		@Override
//		public List<matchMyDto> getMatchList() {
//			
//			List<matchMyDto> matchList = new ArrayList<matchMyDto>();
//			
//			try(SqlSession session = sqlSessionFactory.openSession()) {
//				matchDao mapper =session.getMapper(matchDao.class);
//				
//				matchList = mapper.getMatchList();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			return matchList;
//		}
//		
//}
