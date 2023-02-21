package soccer.deploy.entry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import soccer.deploy.match.entity.Match;
import soccer.deploy.user.entity.User;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
		name = "entry_seq_gen",
		sequenceName = "entry_seq",
		initialValue = 1,
		allocationSize = 1)
public class Entry {
	@Id
	@Column(name ="entry_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_seq_gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="match_id",insertable = false, updatable = false)
	private Match match;
	
	@Column(name="match_id")
	private Long matchId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
