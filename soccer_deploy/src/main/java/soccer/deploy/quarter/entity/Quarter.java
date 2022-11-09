package soccer.deploy.quarter.entity;

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


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
		name = "quarter_seq_gen",
		sequenceName = "quarter_seq",
		initialValue = 1,
		allocationSize = 1)
public class Quarter {
	@Id
	@Column(name ="quarter_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quarter_seq_gen")
	private Long id;
	
	@Column(name ="quarter_time")
	private Integer quarterTime;
	@Column
	private String outcome;
	
	@ManyToOne
	@JoinColumn(name ="match_id")
	private Match match;
}
