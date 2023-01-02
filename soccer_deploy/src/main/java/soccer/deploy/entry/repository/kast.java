package soccer.deploy.entry.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.lineUp.entity.LineUp;
import soccer.deploy.match.entity.Match;
import soccer.deploy.user.entity.User;

@Slf4j
@Transactional
@Repository
public class kast {
	@Autowired
	private EntityManager en;
	
	public void test() {
		String jpql = "select l,e,u,m from LineUp l join l.entry e join e.user u join e.match m";
		List<Object[]> result = en.createQuery(jpql).getResultList();
		
		for(Object[] row: result) {
			
			LineUp l = (LineUp) row[0];
			Entry e = (Entry) row[1];
			User u =(User) row[2];
			Match m = (Match) row[3];
			log.info("line{}",l.getId());
			log.info("user{}",u.getBackNum());
			log.info("match{}",m.getMatchDate());
		}
	}
}
