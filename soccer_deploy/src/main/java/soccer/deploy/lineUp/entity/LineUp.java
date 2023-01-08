package soccer.deploy.lineUp.entity;

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
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.quarter.entity.Quarter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
		name = "lineup_seq_gen",
		sequenceName = "lineup_seq",
		initialValue = 1,
		allocationSize = 1)
public class LineUp {
	@Id
	@Column(name ="lineup_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineup_seq_gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="entry_id")
	private Entry entry;
	
	@ManyToOne
	@JoinColumn(name= "quarter_id")
	private Quarter quarter;
	@Column
	private Integer goal;
	@Column
	private Integer assist;
	@Column
	private Integer point;
}	
