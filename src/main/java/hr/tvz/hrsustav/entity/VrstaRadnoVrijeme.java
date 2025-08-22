package hr.tvz.hrsustav.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class VrstaRadnoVrijeme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator vrste radnog vremena", example = "1")
	private Integer idVrstaRadnoVrijeme;
	@Schema(description = "Naziv vrste radnog vremena", example = "Puno")
	private String naziv;
}