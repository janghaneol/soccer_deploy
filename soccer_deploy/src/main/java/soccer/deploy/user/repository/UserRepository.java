package soccer.deploy.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soccer.deploy.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	/* email , passwd를 이용해 로그인*/
	User findByEmailAndPasswd(String email, String passwd);


}
