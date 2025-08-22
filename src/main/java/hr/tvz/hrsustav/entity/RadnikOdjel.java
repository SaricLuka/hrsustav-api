package hr.tvz.hrsustav.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class RadnikOdjel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRadnikOdjel;
	@ManyToOne
	@JoinColumn(name = "radnik_fk")
	private Radnik radnikFk;
	@ManyToOne
	@JoinColumn(name = "odjel_fk")
	private Odjel odjelFk;
	private Date datumOd;
	private Date datumDo;
}