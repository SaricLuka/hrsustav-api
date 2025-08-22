package hr.tvz.hrsustav.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RadnikPrebivaliste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radnik_preb_seq")
	// @SequenceGenerator(
	// 	name="radnik_preb_seq",
	// 	sequenceName = "radnik_prebivaliste_seq",
	// 	allocationSize = 50
	// )
	private Integer idRadnikPrebivaliste;
	private Integer radnikFk;
	private Integer mjestoFk;
	private String ulica;
	private String kucniBr;
}