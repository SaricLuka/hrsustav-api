package hr.tvz.hrsustav.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class RadnoVrijeme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRadnoVrijeme;
	private Integer vrstaRadnoVrijemeFk;
	private Double tjednoSati;
	private Double dnevnoSati;
	private Integer godisnji;

}