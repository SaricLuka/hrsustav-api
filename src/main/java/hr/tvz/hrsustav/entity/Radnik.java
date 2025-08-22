package hr.tvz.hrsustav.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Radnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRadnik;
	@ManyToOne
	@JoinColumn(name = "radnik_nadred_fk")
	private Radnik radnikNadredFk;
	private String ime;
	private String prezime;
	private String oib;
	@ManyToOne
	@JoinColumn(name = "spol_fk")
	private Spol spolFk;
	private Date datumRod;
	@ManyToOne
	@JoinColumn(name = "radnik_vrsta_fk")
	private RadnikVrsta radnikVrstaFk;
	@OneToMany(mappedBy = "radnikFk")
	private List<RadnikOdjel> radnikOdjel;
	@OneToMany(mappedBy = "radnikFk")
	private List<UgovorRad> ugovorRad;
}