package soccer.deploy.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soccer.deploy.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	/* email , passwd로 로그인*/
	User findByEmailAndPasswd(String email, String passwd);
}
