package soccer.deploy.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import soccer.deploy.dao.JdbcNoticeDao;
import soccer.deploy.dao.noticeDAO;
import soccer.deploy.dto.noticeDTO;

public class ServiceFactoryImpl implements ServiceFactory {
	
	private static ServiceFactoryImpl factory = new ServiceFactoryImpl();
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private DataSource dataSource;
	
	private ServiceFactoryImpl() {
		loadProperties();
		createDataSource();
	}
	
	public static ServiceFactoryImpl getInstance() {
		return factory;
	}
	
	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/resources/jdbc.properties");
		
		System.out.println("답 : "+in);
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(10);     // 풀의 초기 커넥션 개수
		ds.setMaxTotal(100);       // 최대 커넥션 개수
		ds.setMaxIdle(10);         // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		ds.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		dataSource = ds;
	}
	
	public noticeDAO getNoticeDao() {
		return new JdbcNoticeDao(dataSource);
	}

	@Override
	public noticeService getNoticeService() {
		return new noticeServiceImpl(getNoticeDao());
	}
	
	// test main
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactoryImpl.getInstance();
		noticeService userService = serviceFactory.getNoticeService();
//		System.out.println(userService);
//		User user = new User();
//		user.setId("sylee");
//		user.setName("이승엽");
//		user.setPasswd("1111");
//		user.setEmail("sylee@gmail.com");
//		userService.registUser(user);
//		System.out.println("정상 등록 완료..");
		
//		List<User> list = userService.listAll();
//		System.out.println(list);
		
//		User findUser = userService.findById("bangry");
//		System.out.println(findUser);
		
		noticeDTO loginUser = userService.login("bangry", "11222");
		System.out.println(loginUser);
		
		
	}
}
