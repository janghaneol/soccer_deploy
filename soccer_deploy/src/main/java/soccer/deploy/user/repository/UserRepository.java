package soccer.deploy.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	/* email , passwd濡� 濡쒓렇�씤*/
	User findByEmailAndPasswd(String email, String passwd);

	//정충효 엔트리 선수 검색을 위한 부분
	@Query(value="SELECT  u from Entry e join e.user u where e.match.id = :id and LOWER(u.name) like LOWER(concat('%'	,:name,'%'))")
	List<User> findEntryUser(@Param("id") Long id , @Param("name") String name);
}
