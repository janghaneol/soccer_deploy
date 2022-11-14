package soccer.deploy.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soccer.deploy.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	/* email , passwd濡� 濡쒓렇�씤*/
	User findByEmailAndPasswd(String email, String passwd);


}
